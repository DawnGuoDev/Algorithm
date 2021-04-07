volatile int buffer_write_idx = 0;
volatile int buffer_read_idx = 0;
struct lock buffer_lock;
int buffer[5];

void buffer_add_safe(int msg) {
    lock(&buffer_lock);
    buffer[buffer_write_idx] = msg;
    buffer_write_idx = (buffer_write_idx + 1) % 5;
    unlock(&buffer_lock);
}


struct cond empty_cond; // 无空位，生产者阻塞
struct cond filled_cond; // 无数据，消费者阻塞
int empty_count = 5;
int filled_count = 0;
struct lock empty_cnt_lock;
struct lock filled_cnt_lock;

void producer_cond() {
    while (1) {
        int newMsg = produceMsg();
        lock(&empty_cnt_lock);
        while (empty_count == 0) {
            cond_wait(&empty_cond, &empty_cnt_lock);
        }
        empty_count --;
        unlock(&empty_cnt_lock);

        buffer_add_safe(newMsg);

        lock(&filled_cnt_lock);
        filled_count++;
        cond_signal(&filled_cond);
        unlock(&filled_cnt_lock);
    }
}

struct sem empty_sem;
struct sem filled_sem;

void producer_sem() {
    while (1) {
        int newMsg = produceMsg();
        sem_wait(&empty_sem);
        buffer_add_safe(newMsg);
        sem_signal(&filled_sem);
    }
}

void consumer_sem() {
    while (1) {
        sem_wait(&filled_sem);
        int msg = buffer_remove_safe();
        sem_signal(&empty_sem);
        consume_msg(msg);
    }
}

pthread_cond_t cond_empty;          // 消费者的条件变量
pthread_cond_t cond_filled;         // 生产者的条件变量
int empty_slot = 5;                 // 空格的资源
int filled_slot = 0;                // 满格的资源
pthread_mutex_t empty_cnt_lock;     // 空格资源的访问锁
pthread_mutex_t filled_cnd_lock;    // 满格资源的访问锁

volatile int writer_idx = 0;
volatile int reader_idx = 0;
pthread_mutex_t buffer_lock = 0;
int buffer[5];


void producer() {
    while (1) {
        int num = rand() % 100;
        pthread_mutex_lock(&empty_cnt_lock);
        while (empty_slot == 0) {
            pthread_cond_wait(&cond_empty, &empty_cnt_lock);
        }
        empty_slot--;
        pthread_mutex_unlock(&empty_cnt_lock);

        pthread_mutex_lock(&buffer_lock);
        buffer[writer_idx] = num;
        writer_idx = (writer_idx + 1) % 5;
        pthread_mutex_unlock(&buffer_lock);

        pthread_mutex_lock(&filled_cnt_lock);
        filled_slot++;
        pthread_mutex_signal(&cond_filled);
        pthread_mutex_unlock(&filled_cnt_lock);
    }
}
