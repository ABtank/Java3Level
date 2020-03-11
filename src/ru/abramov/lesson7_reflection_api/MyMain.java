package ru.abramov.lesson7_reflection_api;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyMain {

    public static void main(String[] args) {

        TestReflectImpl testReflect1 = new TestReflectImpl(1, "!!!");

        int number = testReflect1.getNumber();
        String name = null;

        printData(testReflect1);
        System.out.println(testReflect1);
        try {
            Field field = testReflect1.getClass().getDeclaredField("name");
            field.setAccessible(true);
            name = (String) field.get(testReflect1);
            System.out.println(name);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        printData(testReflect1);

        System.out.println("******************");

        TestReflectImpl testReflect2 = null;
        TestReflectImpl testReflect3 = null;
        Class clazz = null;

        try {
            try {
                clazz = Class.forName(TestReflectImpl.class.getName());
                testReflect2 = (TestReflectImpl) clazz.newInstance();//создание обьекта по пустому конструктору
                Class[] params = {int.class, String.class}; //получаем все поля
                testReflect3 = (TestReflectImpl) clazz.getConstructor(params).newInstance(1, "!!!");
                printData(testReflect2);
                printData(testReflect3);
                System.out.println("******************");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(testReflect2);
        System.out.println("************");

        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors
        ) {
            Class[] paramTypes = constructor.getParameterTypes();
            for (Class paramType : paramTypes
            ) {
                System.out.println(paramType.getSimpleName() + " - параметр ");
            }
            System.out.println();
        }
    }


    public static void printData(Object myClass) {

        Method method = null;
        try {
            method = myClass.getClass().getDeclaredMethod("printData");
            method.setAccessible(true);
            method.invoke(myClass);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
