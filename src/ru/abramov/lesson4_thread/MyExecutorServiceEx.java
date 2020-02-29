package ru.abramov.lesson4_thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyExecutorServiceEx {
    private final int COUNT = 5;
    SimpleDateFormat sdf = null;
    ExecutorService executorService;

    public MyExecutorServiceEx(){
        sdf = new SimpleDateFormat("HH:mm:ss.S");

        //замок с обратным отсчетом
        CountDownLatch cdl1 =new CountDownLatch(COUNT);
        CountDownLatch cdl2 =new CountDownLatch(COUNT);
        CountDownLatch cdl3 =new CountDownLatch(COUNT);
        CountDownLatch cdl4 =new CountDownLatch(COUNT);

        executorService = Executors.newFixedThreadPool(2);
        System.out.println("start");

        executorService.execute(new MyThread(cdl1, "Thread.1"));
        executorService.execute(new MyThread(cdl2, "Thread.2"));
        executorService.execute(new MyThread(cdl3, "Thread.3"));
        executorService.execute(new MyThread(cdl4, "Thread.4"));

        try{
            cdl1.await();
            cdl2.await();
            cdl3.await();
            cdl4.await();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        executorService.shutdown();
        System.out.println("end");
    }

    void printMess(final String templ){
        String text = sdf.format(new Date())+":"+templ;
        System.out.println(text);
    }

    class MyThread implements Runnable{
        String name;
        CountDownLatch latch;

        public MyThread(CountDownLatch latch, String name) {
            this.name = name;
            this.latch = latch;
            new Thread(this);
        }


        @Override
        public void run() {
            try{
                for (int i = 0; i <COUNT ; i++) {
                    printMess(name+" - "+i);
                    latch.countDown();
                    Thread.sleep((long) (Math.random()*2000));
                }
                printMess(name+"completed");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new MyExecutorServiceEx();

    }
}
