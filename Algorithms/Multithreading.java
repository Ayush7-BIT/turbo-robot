class Thread1 extends Thread {
    public void run() {
        for(int i=1;i<=200;i++) {
            System.out.println("Thread1 is running");
        }
    }
}
class Thread2 extends Thread{
    public void run() {
        for(int i=1;i<=200;i++) {
            System.out.println("Thread2 is running");
        }
    }
}
public class Multithreading {
    public static void main(String[] args) {
        Thread1 obj1 = new Thread1();
        Thread2 obj2 = new Thread2();
        obj1.start();
        obj2.start();
    }
}
