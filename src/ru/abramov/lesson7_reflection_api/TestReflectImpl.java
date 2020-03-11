package ru.abramov.lesson7_reflection_api;

public class TestReflectImpl {

    private int number;
    private String name = "default";

    public TestReflectImpl() {

    }

    public TestReflectImpl(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber() {
        this.number = number;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void printData() {
        System.out.println(number + name);
    }


}
