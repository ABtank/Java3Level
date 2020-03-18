package ru.abramov.BigTaskHomeWork;

public abstract class Fruit {
    private double weight;
    private static int count;
    private String name;

    public Fruit(){
        count++;
        this.name = "Fruit №" + count;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight){
        this.weight=weight;
    }

    @Override
    public String toString() {
        return name;
    }
}
