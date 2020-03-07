package ru.abramov.lesson6_logging.log4j;



//import java.apache.log4j.Logger;
import java.util.logging.Logger;

public class OrderLogic {

    private static final Logger log = Logger.getLogger(OrderLogic.class.getName());

    public void doOrder(){
        //какая-то логика
        System.out.println("Заказ оформлен!");
        //логируем инфо
        log.info("Это информационное сообщение!");
    }

    private void addToCart(){
        //добавление товара в корзину
        System.out.println("Товар добавлен в корзину");
        // логируем ошибку
       // log.error("Это сообщение ошибки");
    }
}


