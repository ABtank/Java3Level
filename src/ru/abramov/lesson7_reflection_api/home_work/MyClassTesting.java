package ru.abramov.lesson7_reflection_api.home_work;

import ru.abramov.lesson7_reflection_api.Cat;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class MyClassTesting {

    public MyClassTesting() {

    }

    private static void start(Class obj) {
        System.out.println("Полное имя класса: " + obj.getName());
        System.out.println("Простое имя класса: " + obj.getSimpleName());
        Field[] publicFields = obj.getFields();
        for (Field o : publicFields) {
            System.out.println("Тип_поля Имя_поля : " + o.getType().getSimpleName() + " " + o.getName());
        }

        int modifiers;
        System.out.println(modifiers = obj.getModifiers());
        if (Modifier.isPublic(modifiers)) {
            System.out.println(obj.getSimpleName() + "- public");
        }
        if (Modifier.isAbstract(modifiers)) {
            System.out.println(obj.getSimpleName() + "- abstract");
        }
        if (Modifier.isFinal(modifiers)) {
            System.out.println(obj.getSimpleName() + "- final");
        }

        System.out.println(Arrays.toString(obj.getInterfaces()));
        System.out.println(Arrays.toString(obj.getDeclaredMethods()));
        System.out.println(Arrays.toString(obj.getDeclaredConstructors()));
        Method[] methods = obj.getDeclaredMethods();
        //Class annotation= TestSuite.class;
        for (Method m : methods) {
            System.out.println("isAnnotation=" + m.isAnnotationPresent(TestSuite.class) +
                    " === " + m.getReturnType() +
                    " === " + m.getName() +
                    " === " + Arrays.toString(m.getParameterTypes()));
        }

    }

    private static void start(String obj) {


    }

    public static void main(String[] args) {
        String a = new String();
        Object o = new Object();
        Cat c = new Cat();
        ClassTest test = new ClassTest();
        start(a.getClass());
        System.out.println("******************************************");
        start(c.getClass());
        System.out.println("******************************************");
        start(o.getClass());
        System.out.println("******************************************");
        start(test.getClass());
    }

}
