package ru.abramov.lesson5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Сравнение с обменом
 * i++; ++i:
 */
public class MyAtomicCounter {
    static AtomicInteger x = new AtomicInteger(0);
    private static Integer integer = 0;
    private static int simpleI = 0;
    private static int count = 0;

    public static void main(String[] args) {
        MyAtomicCounter atomicCounter = new MyAtomicCounter();
        final int THREADS_COUNT = 50; // кол-во потоков
        final int TICKS_COUNT = 50; // количество "тиков" в каждом потоке
        CountDownLatch cdl = new CountDownLatch(THREADS_COUNT);

        for (int q = 0; q < THREADS_COUNT; q++) {
            new Thread(() -> {
                for (int i = 0; i < TICKS_COUNT; i++) {
                    try {
                        Thread.sleep(3); // усыпляем поток на 3 мс.
                        x.getAndAdd(1); // увеличиваем значение AtomicInteger на 1
                        simpleI++;
                        integer = integer + 1;
                        atomicCounter.setInteger(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                cdl.countDown(); // как только поток все посчитал - уменьшаем счетчик
            }).start();
        }

        try {
            cdl.await(); // ждем пока оба потока выполнят все действия
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Integer: " + integer); // не гарантирует
        System.out.println("atomicCounter: " + count);// гарантированно получим THREAD_COUNT*TICK_COUNT
        System.out.println("x: " + x); // гарантированно получим THREADS_COUNT * TICKS_COUNT
        System.out.println("simpleI: " + simpleI); // не гарантирует
    }

    public synchronized Integer getInteger() {
        return integer;
    }

    public synchronized void setInteger(Integer integer) {
        this.count += integer;
    }
}
