package ru.abramov.lesson5;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class ForkJoinFibonacci extends RecursiveAction {

private static final long threshold = 10;
private volatile long numbers;

public ForkJoinFibonacci(long numbers){
    this.numbers=numbers;
}

    public long getNumbers() {
        return numbers;
    }



    @Override
    protected void compute() {
        long n = numbers;
        if(n<=threshold){
            numbers=fib(n);
        }else{
            ForkJoinFibonacci f1 =new ForkJoinFibonacci(n-1);
            ForkJoinFibonacci f2 =new ForkJoinFibonacci(n-2);
            ForkJoinTask.invokeAll(f1,f2);
            numbers=f1.numbers+f2.numbers;
        }
    }

    private static long fib(long n) {
    if(n<=1) return n;
    else return fib(n-1)+fib(n-2);
    }
}

class MainFibonacci{

    public static void main(String[] args) {
        ForkJoinFibonacci task = new ForkJoinFibonacci(50);
        new ForkJoinPool().invoke(task);
        System.out.println(task.getNumbers());
    }
}