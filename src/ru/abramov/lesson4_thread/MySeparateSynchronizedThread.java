package ru.abramov.lesson4_thread;

public class MySeparateSynchronizedThread {
    private Object lock1 = new Object();

    public static void main(String[] args) {
        System.out.println("Старт main потока");
        MySeparateSynchronizedThread msst=new MySeparateSynchronizedThread();
        new Thread(() -> msst.metod()).start();
        new Thread(() -> msst.metod()).start();
    }

    public void  metod() {
        System.out.println("method1 Started");
        System.out.println("First block begin");
        for (int i = 0; i < 3; i++) {
            System.out.print(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
        System.out.println("First block end");
        synchronized (lock1) {
            System.out.println("Begin synchronized block");

            for (int i = 0; i < 10; i++) {
                System.out.print(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
            System.out.println("End synchronized block");
        }
        System.out.println();
        System.out.println("Method end work");
    }
}
