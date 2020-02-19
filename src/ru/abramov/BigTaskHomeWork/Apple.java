package ru.abramov.BigTaskHomeWork;

public class Apple extends Fruit {
    private static int COUNT;
    private static float weight =1.0f;

    public static String getName() {
        return name;
    }

    private static String name;


    public float getWeight() {
        return weight;
    }

    public Apple() {
        COUNT++;
        name="Apple №" + COUNT;
        System.out.println(name);
    }

    public static int getCOUNT() {
        return COUNT;
    }
}
