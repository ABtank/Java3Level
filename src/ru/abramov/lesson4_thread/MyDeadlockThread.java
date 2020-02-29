package ru.abramov.lesson4_thread;

public class MyDeadlockThread {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    /**
     * Взаимная блокировка потоков
     */
    public static void main(String[] args) {
        ThreadOne threadOne = new ThreadOne();
        ThreadTwo threadTwo = new ThreadTwo();
        threadOne.start();
        threadTwo.start();

    }

    private static class ThreadOne extends Thread {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread1 catch Lock1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread1 wait Lock2");
                synchronized (lock2) {
                    System.out.println("Thread1 catch Lock1 and Lock2");
                }
            }
        }
    }

    private static class ThreadTwo extends Thread {
        @Override
        public void run() {
            synchronized (lock2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread2 catch Lock2");
                synchronized (lock1) {
                    System.out.println("Thread2 catch Lock1 and Lock2");
                }
            }
        }
    }
}

