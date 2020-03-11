package ru.abramov.lesson7_reflection_api;

public class Cat {
    public String name;
    public String color;
    public int age;
    private int field;

    public Cat(int field){

    }

    public Cat(){

    }

    public Cat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Cat(String name) {
        this.name = name;
    }

    public void info() {
        System.out.println("field: " + field);
    }

    public void meow(int dB) {
        System.out.println(name + ": meow - " + dB + " dB");
    }

    public void jump(int dB) {
        System.out.println(name + ": jump - " + dB + " dB");
    }

}
