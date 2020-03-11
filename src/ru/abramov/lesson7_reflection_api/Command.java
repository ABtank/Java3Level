package ru.abramov.lesson7_reflection_api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//указывает что наша Аннотация может использоваться во время выполнения
//через Reflection (нам как раз это нужно).
@Target(ElementType.METHOD) //указывает что целью нашей Анотации является метод
// (не класс, не переменная, не поле, а именно метод).
public @interface Command { // Описание. Заметим, что перед interface стоит @;

    String name(); // Команда за которую будет отвечать функция (например "Привет").

    String args(); //Аргументы команды, использоваться будут для списка команд

    int minArgs() default 0;  // Минимальное количество аргументов, сразу присвоили 0 (логично)

    String desc(); // описание. Тоже для списка

    int maxArgs() default Integer.MAX_VALUE; // Максимальное число аргументов. В целом необязательно,
    // но тоже можно использовать

    boolean showInHelp() default true; // Показывать ли команду в списке (вовсе не обязательная строка,
    // но мало ли пригодится

    String[] aliases(); // Какие команды будут считаться эквивалентными нашей
    // (например для "Привет", это может быть "Здаров", "Прив" и т.д., под каждый случай заводить функцию-
    // не рационально
}
