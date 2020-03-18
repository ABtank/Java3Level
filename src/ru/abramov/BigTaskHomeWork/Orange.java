package ru.abramov.BigTaskHomeWork;

public class Orange extends Fruit {
    private static int count;
    private String name;

    public Orange() {
        setWeight(1.5f);
        count++;
        name="Orange №" + count;
    }

    @Override
    public String toString() {
        return super.toString()+" = "+name;
    }

}
