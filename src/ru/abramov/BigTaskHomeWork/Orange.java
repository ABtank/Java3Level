package ru.abramov.BigTaskHomeWork;

public class Orange extends Fruit {
    private static int COUNT;
    private static float weight =1.5f;

    public static float getWeight() {
        return weight;
    }

    public Orange() {
        COUNT++;
        System.out.println("Orange №" + COUNT);
    }

    public static int getCOUNT() {
        return COUNT;
    }
}
