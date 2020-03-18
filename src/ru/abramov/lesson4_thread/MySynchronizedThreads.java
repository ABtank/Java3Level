package ru.abramov.lesson4_thread;

public class MySynchronizedThreads {
    static int number = 20;


    public static void main(String[] args) {
        MySynchronizedThreads mst = new MySynchronizedThreads();
        new Thread(() -> mst.method1()).start();
        new Thread(() -> mst.method2()).start();
        new Thread(() -> mst.method3()).start();
        new Thread(() -> mst.method4()).start();
    }

    /**
     * При такой синхронизации в роли монитора используется
     * обьект у которого был вызван данный метод
     */
    public synchronized void method1() {
        System.out.println("M1");
        for (int i = 0; i < number; i++) {

            System.out.print(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("End M1");
    }

    public synchronized void method2() {
        System.out.println("M2");
        for (int i = 0; i < number; i++) {

            System.out.print(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("End M2");
    }


    /**
     * При указании ключевого слова synchronized
     * в объявлении СТАТИЧЕСКОГО метода в роли монитора
     * выступает сам класс.
     */
    public synchronized static void method3() {
        System.out.println();
        System.out.println("M3");
        for (int i = 0; i < number; i++) {

            System.out.print(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(" End M3");
    }

    public synchronized static void method4() {
        System.out.println();
        System.out.println("M4");
        for (int i = 0; i < number; i++) {

            System.out.print(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(" End M4");
    }
}
