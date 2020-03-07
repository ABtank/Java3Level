package ru.abramov.lesson6_logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ExampleBase {
    //Levels
    //OFF
    //SEVERE
    //WARNING
    //INFO
    //CONFIG
    //FINE
    //FINER
    //FINEST
    //ALL

    private static final Logger logger= Logger.getLogger(ExampleBase.class.getName());

    public static void main(String[] args) {
        ExampleBase ex1 =new ExampleBase();
        ex1.tryToDivBy0();
    }

    private void tryToDivBy0() {
        try{
            int a = 5/0;
        }catch (ArithmeticException e){
            logger.log(Level.SEVERE,"Ошибка деления на ноль",e);
        }
    }
}
