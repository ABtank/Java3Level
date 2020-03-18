package ru.abramov.lesson4_thread;

import java.util.concurrent.*;


public class MyExecutorService {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        /**
         * Метод execute(Runnable) принимает объект java.lang.Runnable и выполняет его асинхронно.
         */
        ExecutorService executorService1 = Executors.newFixedThreadPool(10);
        executorService1.execute(new Runnable() {
            public void run () {
                System.out.println("Асинхронная задача");
            }
        });
        executorService1.shutdown(); // всегда необходимо останавливать ExecutorService
        executorService1.shutdownNow(); // немедленая остановка с потерей данных и не обработанными задачами

        /**
         * Метод submit(Runnable) также принимает реализацию Runnable, но возвращает объект типа Future,
         * который можно использовать для проверки завершенности выполнения задачи.
         */
        ExecutorService executorService2 = Executors.newFixedThreadPool(2);
        Future future1 = executorService2.submit(new Runnable() {
            public void run() {
                System.out.println("Асинхронная задача");
            }
        });
        future1.get();  // вернет null если задача завершилась корректно
        executorService2.shutdown();

        /**
         * submit (Callable)
         * Экземпляр Callable также позволяет дать потоку задачу, но в отличие от Runnable, его метод call()
         * может возвращать результат. Результат Callable может быть получен через объект Future,
         * возвращенный методом submit.
         */
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future future2 = executorService.submit(new Callable(){
            public Object call() throws Exception {
                System.out.println("Асинхронный вызов");
                return "Результат из потока";
            }
        });
        System.out.println("future2.get() = " + future2.get());
        executorService.shutdown();
    }

}

