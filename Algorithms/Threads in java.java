// Extending the Thread class
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread from MyThread is running");
    }
}

// Implementing the Runnable interface
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread from MyRunnable is running");
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        // Using MyThread
        MyThread myThread = new MyThread();
        myThread.start();

        // Using MyRunnable
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
    }
}
