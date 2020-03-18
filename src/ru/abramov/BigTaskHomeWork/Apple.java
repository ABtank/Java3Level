package ru.abramov.BigTaskHomeWork;

public class Apple extends Fruit {
    private static int count;
    private String name;

    public Apple() {
        setWeight(1.0f);
        count++;
        this.name = "Apple №" + count;
        //System.out.println(name);
    }

    @Override
    public String toString() {
        return super.toString() + " = " + name;
    }

}
