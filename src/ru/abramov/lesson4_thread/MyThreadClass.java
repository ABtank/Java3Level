package ru.abramov.lesson4_thread;

//необходим если нужно переопределить не только метод run()
public class MyThreadClass extends Thread {
    static int i=0;
    @Override
    public void run() {
        for ( i = 0; i <10 ; i++) {
            try{
                Thread.sleep(100);
                System.out.println(getName()+"|"+i);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new MyThreadClass().start();
        MyThreadClass priorityThread = new MyThreadClass();
        priorityThread.setPriority(10);
        priorityThread.start();
    }
}
