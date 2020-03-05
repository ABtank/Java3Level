package ru.abramov.lesson5;

import java.util.concurrent.CountDownLatch;

public class MyCountDownLatch {
    public static void main(String[] args) {
        //задаем количество потоков
        final int THREAD_COUNT = 6;
        //задаем значение счетчика
        final CountDownLatch cdl = new CountDownLatch(THREAD_COUNT);
        System.out.println("Start");
        for (int i = 0; i <THREAD_COUNT ; i++) {
            final int w = i;
            new Thread(()->{
                try{
                 //считаем что выполнение задачи занимает 1сак
                 Thread.sleep(500 +(int)(Math.random()*500));
                 cdl.countDown();
                 //как только задача выполнена, уменьшаем счетчик
                    System.out.println("Thread #"+w+" - ready");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }).start();
        }
        try{
            cdl.await();
            //пока счетчик не приравнятся к нулю, будем стоять на этой строке
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        // как только все потоки выполнили свои задачи - пишем сообщение
        System.out.println("Work done");
    }
}
