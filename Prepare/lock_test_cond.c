#include<stdio.h>
#include<pthread.h>
#include<stdlib.h>
#include<unistd.h>

pthread_mutex_t mutex;
pthread_cond_t cond1, cond2;

void* thread1(void *arg) {
    int num = 1;

    while (1) {
        pthread_mutex_lock(&mutex);
        if (num > 26) {
            exit(1);
        }
        printf("%d ", num);
        num++;
        pthread_cond_signal(&cond2);
        pthread_cond_wait(&cond1, &mutex);
        pthread_mutex_unlock(&mutex);
        sleep(0.01);
    }

    return NULL;
}

void* thread2(void *arg) {
    int num = 0;
    while (1) {
        sleep(0.01);   // 先让 thread1 执行
        pthread_mutex_lock(&mutex);

        if (num >= 26) {
            exit(1);
        }

        printf("%c ", num+'a');
        num++;
        pthread_cond_signal(&cond1);
        pthread_cond_wait(&cond2, &mutex);
        pthread_mutex_unlock(&mutex);
    }

    return NULL;
}

int main() {
    pthread_t p1, p2;

    pthread_mutex_init(&mutex, NULL);
    pthread_cond_init(&cond1, NULL);
    pthread_cond_init(&cond2, NULL);

    pthread_create(&p1, NULL, thread1, NULL);   // 创建线程
    pthread_create(&p2, NULL, thread2, NULL);
    pthread_join(p1, NULL); // 等待线程结束
    pthread_join(p2, NULL);

    pthread_mutex_destroy(&mutex);
    pthread_cond_destroy(&cond1);
    pthread_cond_destroy(&cond2);

    return 0;
}

