import java.util.Random;

class SequentialTask {
    public void performTask() {
        Random random = new Random();
        long sum = 0;
        for (int i = 0; i < 100000000; i++) { // Simulating heavy computation
            sum += random.nextInt(100);
        }
        System.out.println("Sequential Task Done. Sum: " + sum);
    }
}

class MultithreadedTask implements Runnable {
    @Override
    public void run() {
        Random random = new Random();
        long sum = 0;
        for (int i = 0; i < 100000000; i++) { // Simulating heavy computation
            sum += random.nextInt(100);
        }
        System.out.println(Thread.currentThread().getName() + " Task Done. Sum: " + sum);
    }
}

public class MultithreadingDemo {
    public static void main(String[] args) {
        // Measure time for sequential execution
        long sequentialStart = System.currentTimeMillis();

        SequentialTask task = new SequentialTask();
        task.performTask();
        task.performTask();
        task.performTask(); // Running the task three times sequentially

        long sequentialEnd = System.currentTimeMillis();
        System.out.println("Sequential execution time: " + (sequentialEnd - sequentialStart) + " ms");

        // Measure time for multithreaded execution
        long multithreadedStart = System.currentTimeMillis();

        Thread thread1 = new Thread(new MultithreadedTask(), "Thread-1");
        Thread thread2 = new Thread(new MultithreadedTask(), "Thread-2");
        Thread thread3 = new Thread(new MultithreadedTask(), "Thread-3");

        // Start all threads
        thread1.start();
        thread2.start();
        thread3.start();

        // Wait for all threads to finish
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long multithreadedEnd = System.currentTimeMillis();
        System.out.println("Multithreaded execution time: " + (multithreadedEnd - multithreadedStart) + " ms");
    }
}
