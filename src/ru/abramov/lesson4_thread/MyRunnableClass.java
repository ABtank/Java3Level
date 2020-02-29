package ru.abramov.lesson4_thread;

// запуск потока через реализацию интерфейса
// позволяет наследоваться от других классов
public class MyRunnableClass implements Runnable  {
    static int i =0;
    @Override
    public void run() {
        for ( i = 0; i <10 ; i++) {
            try{
                Thread.sleep(100);
                System.out.println(i);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        new Thread(new MyRunnableClass()).start();
        new Thread(new MyRunnableClass()).start();
    }
}
