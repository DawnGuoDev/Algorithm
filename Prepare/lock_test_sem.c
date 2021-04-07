#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>
#include <semaphore.h>
#include <time.h>

#define BUFSIZE 10

sem_t sem_empty;
sem_t sem_num;
pthread_mutex_t buffer_mutex;
int write_idx = 0;
int read_idx = 0;
int buffer[5];

void *producer(void *arg) {
    while (1) {
        int innum = rand() % 100;
        sem_wait(&sem_empty);

        pthread_mutex_lock(&buffer_mutex);
        buffer[write_idx] = innum;
        printf("producer: %d, %d \n", innum, write_idx);
        write_idx = (write_idx + 1) % 5;
        pthread_mutex_unlock(&buffer_mutex);

        sem_post(&sem_num);
        usleep(1000);
    }
}

void *consumer(void *arg) {
    while (1) {
        sem_wait(&sem_num);
        
        pthread_mutex_lock(&buffer_mutex);
        int outnum = buffer[read_idx];
        printf("consumer: %d, %d \n", outnum, read_idx);
        read_idx = (read_idx + 1) % 5;
        pthread_mutex_unlock(&buffer_mutex);

        sem_post(&sem_empty);
        usleep(10000);
    }
}

int main() {
    pthread_t producer1, consumer1;

    sem_init(&sem_empty, 0, 5);
    sem_init(&sem_num, 0, 0);
    
    pthread_mutex_init(&buffer_mutex, NULL);

    pthread_create(&producer1, NULL, producer, NULL);
    pthread_create(&consumer1, NULL, consumer, NULL);

    pthread_join(producer1, NULL);
    pthread_join(consumer1, NULL);

    sem_destroy(&sem_empty);
    sem_destroy(&sem_num);
    pthread_mutex_destroy(&buffer_mutex);

    return 0;
}