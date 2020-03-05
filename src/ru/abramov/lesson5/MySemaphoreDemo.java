package ru.abramov.lesson5;

import java.util.concurrent.Semaphore;

public class MySemaphoreDemo {

    public static void main(String[] args) {
        Semaphore smp = new Semaphore(2);
        for (int i = 0; i < 5; i++) {
            final int w = i;
            new Thread(() -> {
                try {
                    System.out.println("Thread " + w + " before semaphore");
                    smp.acquire();
                    System.out.println("Thread " + w + " obtain access to resources");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("Thread " + w + " freed resources.");
                    smp.release();
                }
            }).start();
        }
    }
}
