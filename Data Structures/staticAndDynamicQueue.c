#include <stdio.h>
#include <stdlib.h>
#define MAX_SIZE 10
// Static linear queue structure
struct StaticQueue {
    int arr[MAX_SIZE];
    int front;
    int rear;
};
// Dynamic linear queue structure
struct DynamicQueue {
    int *arr;
    int capacity;
    int front;
    int rear;
};

// Function prototypes for static linear queue
void initializeStaticQueue(struct StaticQueue *q);
int isStaticQueueEmpty(struct StaticQueue *q);
int isStaticQueueFull(struct StaticQueue *q);
void enqueueStatic(struct StaticQueue *q, int data);
int dequeueStatic(struct StaticQueue *q);
void printStaticQueue(struct StaticQueue *q);

// Function prototypes for dynamic linear queue
struct DynamicQueue* createDynamicQueue(int capacity);
int isDynamicQueueEmpty(struct DynamicQueue *q);
int isDynamicQueueFull(struct DynamicQueue *q);
void resizeDynamicQueue(struct DynamicQueue *q);
void enqueueDynamic(struct DynamicQueue *q, int data);
int dequeueDynamic(struct DynamicQueue *q);
void printDynamicQueue(struct DynamicQueue *q);

int main() {
    int choice, data;
    struct StaticQueue static_queue;
    struct DynamicQueue *dynamic_queue = NULL;

    // Initialize static queue
    initializeStaticQueue(&static_queue);
    while (1) {
        printf("\nMenu:\n");
        printf("1. Static Queue - Enqueue\n");
        printf("2. Static Queue - Dequeue\n");
        printf("3. Dynamic Queue - Enqueue\n");
        printf("4. Dynamic Queue - Dequeue\n");
        printf("5. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);
        switch (choice) {
            case 1:
                printf("Enter data to enqueue onto static queue: ");
                scanf("%d", &data);
                enqueueStatic(&static_queue, data);
                printf("Static Queue after enqueue: ");
                printStaticQueue(&static_queue);
                break;
            case 2:
                if (!isStaticQueueEmpty(&static_queue)) {
                    printf("Dequeued element from static queue: %d\n", dequeueStatic(&static_queue));
                    printf("Static Queue after dequeue: ");
                    printStaticQueue(&static_queue);
                } else {
                    printf("Static Queue is empty. Cannot dequeue.\n");
                }
                break;
            case 3:
                if (dynamic_queue == NULL) {
                    int capacity;
                    printf("Enter initial capacity for dynamic queue: ");
                    scanf("%d", &capacity);
                    dynamic_queue = createDynamicQueue(capacity);
                }
                printf("Enter data to enqueue onto dynamic queue: ");
                scanf("%d", &data);
                enqueueDynamic(dynamic_queue, data);
                printf("Dynamic Queue after enqueue: ");
                printDynamicQueue(dynamic_queue);
                break;
            case 4:
                if (dynamic_queue != NULL) {
                    if (!isDynamicQueueEmpty(dynamic_queue)) {
                        printf("Dequeued element from dynamic queue: %d\n", dequeueDynamic(dynamic_queue));
                        printf("Dynamic Queue after dequeue: ");
                        printDynamicQueue(dynamic_queue);
                    } else {
                        printf("Dynamic Queue is empty. Cannot dequeue.\n");
                    }
                } else {
                    printf("Dynamic Queue is not initialized.\n");
                }
                break;
            case 5:
                printf("Exiting program.\n");
                if (dynamic_queue != NULL) {
                    free(dynamic_queue->arr);
                    free(dynamic_queue);
                }
                return 0;
            default:
                printf("Invalid choice. Please enter a number between 1 and 5.\n");
        }
    }
}

// Initialize static queue
void initializeStaticQueue(struct StaticQueue *q) {
    q->front = -1;
    q->rear = -1;
}
// Check if static queue is empty
int isStaticQueueEmpty(struct StaticQueue *q) {
    return (q->front == -1 && q->rear == -1);
}
// Check if static queue is full
int isStaticQueueFull(struct StaticQueue *q) {
    return ((q->rear + 1) % MAX_SIZE == q->front);
}
// Enqueue data onto static queue
void enqueueStatic(struct StaticQueue *q, int data) {
    if (isStaticQueueFull(q)) {
        printf("Static Queue Overflow. Cannot enqueue.\n");
        return;
    }
    if (isStaticQueueEmpty(q)) {
        q->front = 0;
    }
    q->rear = (q->rear + 1) % MAX_SIZE;
    q->arr[q->rear] = data;
}
// Dequeue data from static queue
int dequeueStatic(struct StaticQueue *q) {
    if (isStaticQueueEmpty(q)) {
        printf("Static Queue Underflow. Cannot dequeue.\n");
        return -1;
    }
    int data = q->arr[q->front];
    if (q->front == q->rear) {
        q->front = -1;
        q->rear = -1;
    } else {
        q->front = (q->front + 1) % MAX_SIZE;
    }
    return data;
}
// Print static queue
void printStaticQueue(struct StaticQueue *q) {
    if (isStaticQueueEmpty(q)) {
        printf("Static Queue is empty.\n");
        return;
    }
    int i = q->front;
    do {
        printf("%d ", q->arr[i]);
        i = (i + 1) % MAX_SIZE;
    } while (i != (q->rear + 1) % MAX_SIZE);
    printf("\n");
}

// Create a dynamic queue
struct DynamicQueue* createDynamicQueue(int capacity) {
    struct DynamicQueue *q = (struct DynamicQueue*)malloc(sizeof(struct DynamicQueue));
    q->capacity = capacity;
    q->front = -1;
    q->rear = -1;
    q->arr = (int*)malloc(q->capacity * sizeof(int));
    return q;
}
// Check if dynamic queue is empty
int isDynamicQueueEmpty(struct DynamicQueue *q) {
    return (q->front == -1);
}
// Check if dynamic queue is full
int isDynamicQueueFull(struct DynamicQueue *q) {
    return ((q->rear + 1) % q->capacity == q->front);
}
// Resize dynamic queue
void resizeDynamicQueue(struct DynamicQueue *q) {
    q->capacity *= 2;
    q->arr = (int*)realloc(q->arr, q->capacity * sizeof(int));
}
// Enqueue data onto dynamic queue
void enqueueDynamic(struct DynamicQueue *q, int data) {
    if (isDynamicQueueFull(q)) {
        resizeDynamicQueue(q);
    }
    if (isDynamicQueueEmpty(q)) {
        q->front = 0;
    }
    q->rear = (q->rear + 1) % q->capacity;
    q->arr[q->rear] = data;
}
// Dequeue data from dynamic queue
int dequeueDynamic(struct DynamicQueue *q) {
    if (isDynamicQueueEmpty(q)) {
        printf("Dynamic Queue Underflow. Cannot dequeue.\n");
        return -1;
    }
    int data = q->arr[q->front];
    if (q->front == q->rear) {
        q->front = -1;
        q->rear = -1;
    } else {
        q->front = (q->front + 1) % q->capacity;
    }
    return data;
}
// Print dynamic queue
void printDynamicQueue(struct DynamicQueue *q) {
    if (isDynamicQueueEmpty(q)) {
        printf("Dynamic Queue is empty.\n");
        return;
    }
    int i = q->front;
    do {
        printf("%d ", q->arr[i]);
        i = (i + 1) % q->capacity;
    } while (i != (q->rear + 1) % q->capacity);
    printf("\n");
}
