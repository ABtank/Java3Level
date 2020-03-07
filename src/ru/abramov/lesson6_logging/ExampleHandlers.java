package ru.abramov.lesson6_logging;

import sun.net.www.protocol.http.logging.HttpLogFormatter;

import java.io.IOException;
import java.util.logging.*;

public class ExampleHandlers {

    private static final Logger logger = Logger.getLogger(ExampleHandlers.class.getName());

    public static void main(String[] args) {
        try{
            Handler h = new FileHandler("myLogSimple.log");// берем файл, обьявляем его в конструкторе Handler
            h.setFormatter(new SimpleFormatter()); // прикрепляем ему какой-то формат
            logger.addHandler(h); // устанавливаем к нашему логеру Handler

            h = new FileHandler("myLogXml.log");
            h.setFormatter(new HttpLogFormatter());
            logger.addHandler(h);
//            h = new SocketHandler();
//            h = new ConsoleHandler();
//            h = new StreamHandler();
//            h = new MemoryHandler();
            System.out.println("Handlers");
            for (Handler o: logger.getHandlers()
                 ) {
                System.out.println(o);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        ExampleHandlers ex2 = new ExampleHandlers();
        ex2.tryToDivBy0();
    }

    private void tryToDivBy0() {
        try{
            int a = 5/0;
        }catch (ArithmeticException e){
            logger.log(Level.SEVERE,"Ошибка деления на ноль",e);
        }
    }
}
