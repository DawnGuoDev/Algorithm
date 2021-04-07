// 皮特森算法
while (TRUE) {
    flag[0] = TRUE;
    turn = 1;
    while (flag[1] == TRUE && turn == 1) {
        ;
    }

    /*
      临界区代码
     */
    
    flag[0] = false;

    /*
     其他代码
     */
}

while (TRUE) {
    flag[1] = TRUE;
    turn = 0;
    while (flag[0] == TRUE && turn == 0) {
        ;
    }

    /*
     临界区代码
     */

    flag[1] = false;
    
    /*
     其他代码 
     */
}

// CAS，可以使用指令实现原子操作
int CAS(int *addr, int expected, int new_value) {
    int tmp = *addr;
    if (tmp == expected) {
        *addr = new_value;
    }

    return tmp;
}

// FAA，可以使用指令实现原子操作 
int FAA(int *addr, int add_value) {
    int tmp = *addr;
    *addr = tmp + add_value;
    return tmp;
}

/*
自旋锁实现，使用 CAS
*/
void lock_init(int *lock) {
    *lock = 0;
}

void lock(int *lock) {
    while (atomic_CAS(lock, 0, 1) != 0) {
        ;
    }
}

void unlock(int *lock) {
    *lock = 0;
}


/*
排号自旋锁，使用 FAA
*/
struct lock {
    volatile int owner;
    volatile int next;
};

void lock_init(struct lock *lock) {
    lock->owner = 0;
    lock->next = 0;
}

void lock(struct lock *lock) {
    volatile int my_ticket = atomic_FAA(&lock->next, 1);
    while (lock->owner != my_ticket) {
        ;
    }
}

void unlock(struct lock *lock) {
    lock->owner++;
}

// 使用互斥锁来实现生产者消费者
volatile int buffer_write_cnt = 0;
volatile int buffer_read_cnt = 0;
struct lock buffer_lock;
int buffer[5];

void buffer_init(void) {
    lock_init(&buffer_lock);
}

void buffer_add_safe(int msg) {
    lock(&buffer_lock);
    buffer[buffer_write_cnt] = msg;
    buffer_write_cnt = (buffer_write_cnt + 1) % 5;
    unlock(&buffer_lock);
}

int buffer_remove_safe(void) {
    lock(&buffer_lock);
    int ret = buffer[buffer_read_cnt];
    buffer_read_cnt = (buffer_read_cnt + 1) % 5;
    unlock(&buffer_lock);
    
    return ret;
}


/*
条件变量的相关实现
*/
struct cond {
    struct thread *wait_list;
};

void cond_wait(struct cond *cond, struct lock *mutex) {
    list_append(cond->wait_list, thread_self());
    atomic_block_unlock(mutex); // 原子挂起并释放锁
    lock(mutex);    // 重新获取锁
}

void cond_signal(struct cond *cond) {
    if (!list_empty(cond->wait_list)) {
        wakeup(list_remove(cond->wait_list));
    }
}

void cond_broadcast(struct cond *cond) {
    while (!list_empty(cond->wait_list)) {
        wakeup(list_remove(cond->wait_list));
    }
}

int filled_slot = 0;
int empty_slot = 5;
struct cond empty_cond;
struct lock empty_cnt_lock;
struct cond filled_cond;
struct lock filled_cnt_lock;

void producer(void) {
    int new_msg;
    while (TRUE) {
        new_msg = produce_new();
        lock(&empty_cnt_lock);
        while (empty_slot == 0) {
            cond_wait(&empty_cond, &empty_cnt_lock);
        }
        empty_slot--;
        unlock(&empty_cnt_lock);
    
        buffer_add_safe(new_msg);

        lock(&filled_cnt_lock);
        filled_slot++;
        cond_signal(&filled_cond);
        unlock(&filled_cnt_lock);
    }
}

void consumer(void) {
    int cur_msg;

    while (TRUE) {
        lock(&filled_cnt_lock);
        while (filled_slot == 0) {
            cond_wait(&filled_cond, &filled_cnt_lock);
        }
        filled_slot--;
        unlock(&filled_cnt_lock);

        cur_msg = buffer_remove_safe();

        lock(&empty_cnt_lock);
        empty_slot++;
        cond_signal(&empty_cond);
        unlock(&empty_cnt_lock);

        consume_msg(cur_msg);
    }
}

/*信号量的实现*/
void wait(int *s) {
    while (*s <= 0) {
        ; // 循环忙等
    }
    *s = *s - 1;
}

void signal(int *s) {
    *s = *s + 1;
}

struct sem {
    int value;      // 为正数或零，表示剩余的资源量；为负数，负数的绝对值表示等待获取资源的线程数量
    int wakeup;     // 只能为正数或零，表示应当唤醒的线程数量，也表示有线程等待时的可用资源数量
    struct lock sem_lock;
    struct cond sem_cond;
};

void wait(struct sem *s) {
    lock(&s->sem_lock);
    s->value--;
    if (s->value < 0) {
        do {
            cond_wait(&s->sem_cond, &s->sem_lock);
        }while(s->wakeup == 0);
        s->wakeup--;
    }
    unlock(&s->sem_lock);
}

void signal(struct sem *s) {
    lock(&s->sem_lock);
    s->value++;
    if (s->value <= 0) {
        s->wakeup++;
        cond_signal(&s->sem_cond);
    }
    unlock(&s->sem_lock);
}


struct sem empty_slot;
struct sem filled_slot;

void producer(void) {
    int new_msg;

    while (TRUE) {
        new_msg = produce_new();
        wait(&empty_slot);      // p
        buffer_add_safe(new_msg);
        signal(&filled_slot);   // v
    }
}

void consumer(void) {
    int cur_msg;

    while (TRUE) {
        wait(&filled_slot);     // p
        cur_msg = buffer_remove_safe();
        signal(&empty_slot);    // v
        consume_msg(cur_msg);
    }
}

// 读写锁使用示例
struct rwlock lock;
char data[SIZE];

void reader(void) {
    lock_reader(&lock);
    read_data(data);    // 读临界区
    unlock_reader(&lock);
}

void writer(void) {
    lock_writer(&lock);
    update_data(data);
    unlock_writer(&lock);
}

// 偏向读者的读写锁
struct rwlock {
    int reader_cnt;
    struct lock reader_lock;
    struct lock writer_lock;
}

void lock_reader(struct rwlock *lock) {
    lock(&lock->reader_lock);
    lock->reader_cnt++;
    if (lock->reader_cnt == 1) {    // 第一个读者
        lock(&lock->writer_lock);
    }
    unlock(&lock->reader_lock);
}

void unlock_reader(struct rwlock *lock) {
    lock(&lock->reader_lock);
    lock->reader_cnt--;
    if (lock->reader_cnt == 0) {    // 最后一个读者
        unlock(&lock->writer_lock);
    }
    unlock(&lock->reader_lock);
}

void lock_writer(struct rwlock *lock) {
    lock(&lock->writer_lock);
}

void unlock_writer(struct rwlock *lock) {
    unlock(&lock->writer_lock);
}

// 偏向写者的读写锁
