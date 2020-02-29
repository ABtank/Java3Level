package ru.abramov.lesson4_thread;

public class MyRunnable {
    static class RunnableClass implements Runnable{
        boolean suspended = false;

        @Override
        public void run() {
            System.out.println("Start Thread");
            try{
                for (int i = 10; i >0 ; i--) {
                    System.out.println(i);
                    Thread.sleep(300);
                    synchronized (this){
                        while (suspended){
                            System.out.println("Thread wait");
                            wait();
                        }
                    }
                }
            }catch (InterruptedException e){
                System.out.println("Thread interrupted");
            }
            System.out.println("Thread Completed");
        }

        public void mySuspend(){
            suspended=true;
        }

        public synchronized void myResume(){
            suspended=false;
            notify();
        }

        public static void main(String[] args) {
            RunnableClass rc = new RunnableClass();
            new Thread(rc).start();
            try{
                Thread.sleep(1000);
                rc.mySuspend();
                Thread.sleep(3000);
                rc.myResume();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
