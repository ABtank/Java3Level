package ru.abramov.lesson6_logging;

import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class ExampleFilters {

    private static final Logger logger = Logger.getLogger(ExampleFilters.class.getName());

    public static void main(String[] args) {
        Filter flt = new Filter() {
            @Override
            public boolean isLoggable(LogRecord record) {
                return true;
            }
        };
        logger.setFilter(flt);
        logger.log(Level.SEVERE, "Java 1");
        logger.log(Level.SEVERE, "Java 2");


        System.out.println("======================");

        Filter flt2 = new Filter() {
            @Override
            public boolean isLoggable(LogRecord record) {
                if(record.getMessage().startsWith("Java"))
                    return true;
                System.out.println("log msg rejected..");
                return false;
            }
        };
        logger.setFilter(flt2);
        logger.log(Level.SEVERE, "Java 3");
        logger.log(Level.SEVERE, "3 Java");

        System.err.println(logger.getParent().getName());
    }
}
