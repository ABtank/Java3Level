package ru.abramov.lesson6_logging.log4j;

public class Main {
    private static OrderLogic logic;

    public static void main(String[] args) {
        logic = new OrderLogic();
        logic.doOrder();
    }
}