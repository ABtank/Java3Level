package ru.abramov.lesson5;

import java.util.concurrent.CyclicBarrier;

public class MyCyclicBarrier {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3);
        for (int i = 0; i < 3; i++) {
            final int w = i;
            new Thread(() -> {
                try {
                    System.out.println("Thread " + w + " prepare.");
                    Thread.sleep(100 + (int) (Math.random() * 3000));
                    System.out.println("Thread " + w + " ready.");
                    cb.await();
                    System.out.println("Thread " + w + " start");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
