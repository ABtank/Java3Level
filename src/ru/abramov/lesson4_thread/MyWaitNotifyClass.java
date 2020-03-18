package ru.abramov.lesson4_thread;

public class MyWaitNotifyClass {
    private final Object mon = new Object();
    private static volatile char currentLetter = 'A';
    static int number = 5;


    public static void main(String[] args) {
        MyWaitNotifyClass w = new MyWaitNotifyClass();
       Thread t1 = new Thread(() -> {
            w.printA('A');
        });
        Thread t2 = new Thread(() -> {
            w.printDifChar('B', 'C');
        });
        Thread t3 = new Thread(() -> {
            w.printDifChar('C', 'D');
        });
        Thread t4 = new Thread(() -> {
            w.printDifChar('D', 'E');
        });
        Thread t5 = new Thread(() -> {
            w.printDifChar('E', 'A');
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        /**
         * И тут меня понесло :)
         */
        Thread[] threads = new Thread[26];
        threadArr(w, threads, currentLetter);
    }

    private static synchronized void threadArr(MyWaitNotifyClass w, Thread[] threads, char start) {
        for (int i = 0; i < threads.length; i++) {
            if (i == 0) {
                threads[i] = new Thread(() -> {
                    System.out.println();
                    w.printA(start);
                });
                threads[i].start();
            } else if (i == threads.length - 1) {
                int finalI = i;
                threads[i] = new Thread(() -> {
                    w.printDifChar((char) (start + finalI), start);
                });
                threads[i].start();
                break;
            } else {
                int finalI = i;
                threads[i] = new Thread(() -> {
                    w.printDifChar((char) (start + finalI), (char) (start + 1 + finalI));
                });
                threads[i].start();
            }
        }
    }

    private void printA(char first) {
        synchronized (mon) {
            try {
                for (int i = 0; i < number; i++) {
                    while (currentLetter != first) {
                        mon.wait();
                    }
                    if (i != 0) System.out.println();
                    System.out.print(i + 1 + "|");
                    System.out.print(first);
                    currentLetter = (char)(first+1);
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printB() {
        synchronized (mon) {
            try {
                for (int i = 0; i < number; i++) {
                    while (currentLetter != 'B') {
                        mon.wait();
                    }
                    System.out.print("B");
                    currentLetter = 'C';
                    mon.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printDifChar(char first, char second) {
        synchronized (mon) {
            try {
                for (int i = 0; i < number; i++) {
                    while (currentLetter != first) {
                        mon.wait();
                    }
                    System.out.print(first);
                    currentLetter = second;
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
