package ru.abramov.lesson7_reflection_api;

import ru.abramov.lesson6_testing.Calculator;

import java.lang.reflect.*;
import java.util.Arrays;

public class GetClass {

    public static void main(String[] args) {
        System.out.println("----------------------------");
        //1) у любого обьекта есть метод getClass
        Class stringClass = "Java".getClass();

        // 2) Запросить объект типа  Class напрямую у класса
        stringClass = String.class;
        Class integerClass = Integer.class;
        Class intClass = int.class;
        Class voidClass = void.class;
        Class charArrayClass = char[].class;

        // 3) Вызвать статический метод Class.forName(),
        // и передать ему полное имя класса в качестве аргумента.
        try{
            Class jdbc = Class.forName("org.sqlite.jdbc");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        Class s = String.class;
        System.out.println("Полное имя класса: " + s.getName());
        System.out.println("Простое имя класса: " + s.getSimpleName());

        System.out.println("----------------------------");
        /**
         * Модификаторы класса. Метод getModifiers() возвращает значение типа int,
         * из которого, с помощью статических методов класса Modifier, можно определить
         * какие именно модификаторы были применены к классу.
         */
        Class strClass = String.class;
        int modifiers = stringClass.getModifiers();
        if(Modifier.isPublic(modifiers)){
            System.out.println(strClass.getSimpleName()+"- public");
        }
        if(Modifier.isAbstract(modifiers)){
            System.out.println(strClass.getSimpleName()+"- abstract");
        }
        if(Modifier.isFinal(modifiers)){
            System.out.println(strClass.getSimpleName()+"- final");
        }
        System.out.println("Для проверки модификаторов используются методы" +
                " isPublic(), isPrivate(), isAbstract(),\n" +
                " isFinal(), isNative(), isInterface(), isSynchronized(),\n" +
                " isVolatile(), isStrict(), isTransient(), isProtected(),\n" +
                " isStatic().\n");

        String st = "interface";
        System.out.println(Arrays.toString(st.getClass().getInterfaces()));

        //Поля класса getFields() - получение полей доступа public
        Class catClass = Cat.class;
        Field[] publicFields = catClass.getFields();
        for (Field o : publicFields) {
            System.out.println("Тип_поля Имя_поля : " + o.getType().getName() + " " + o.getName());
        }


        System.out.println("----------------------------");
        //все поля класса (public, private и protected), применяют метод
        // getDeclaredFields(). Зная имя поля, можно получить ссылку на него
        // через метод getField() или getDeclaredField()
        try {
            Field f = catClass.getDeclaredField("name");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        System.out.println("----------------------------");
        //Получить значение поля можно с помощью метода get(),
        // который принимает входным параметром ссылку на объект класса.
        // Для «чтения» примитивных типов применяют методы getInt(), getFloat(),
        // getByte() и другие. Метод set() предназначен для изменения значения поля.

        try {
            Cat cat = new Cat();
            Field fieldName = cat.getClass().getField("name");
            fieldName.set(cat, "Мурзик");
            Field fieldAge = cat.getClass().getField("age");
            System.out.println(fieldAge.get(cat));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println("----------------------------");
        /**
         * Посредством рефлексии можно получать и изменять
         * значения полей с модификатором доступа private.
         * Изменить final поле нельзя даже при помощи рефлексии.
         */
        try {
            Cat obj = new Cat(10);
            obj.info();
            //получаем обьект типа field
            Field privateField = Cat.class.getDeclaredField("field");
            // открываем к нему доступ через setAccessible(true)
            privateField.setAccessible(true);
            System.out.println("get: " + privateField.get(obj));
            //изменяем поле
            privateField.set(obj, 1000);
            obj.info();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println("----------------------------");
        System.out.println("Конструкторы класса");
        /**
         * Конструкторы класса
         * Методы getConstructors() и getDeclaredConstructors() возвращают
         * массив объектов типа Constructor. Они содержат в себе информацию
         * о конструкторах класса: имя, модификаторы, типы параметров,
         * генерируемые исключения. Если известен набор параметров конструктора,
         * можно получить ссылку на него с помощью getConstructor() или getDeclaredConstructor().
         */
        Constructor[] constructors = Cat.class.getConstructors();
        for (Constructor o : constructors) {
            System.out.println(o);
        }
        System.out.println("---");
        try {
            System.out.println(Cat.class.getConstructor(new Class[] {String.class, int.class}));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        System.out.println("----------------------------");

        /**
         * Методы getMethods() и getDeclaredMethods() возвращают массив объектов типа Method,
         * в которых содержится полная информация о методах класса. Если известно имя метода
         * и набор входных параметров, то можно получить ссылку на него с помощью
         * getMethod() или getDeclaredMethod().
         */
        System.out.println("Работа с методами");
        Method[] methods = Cat.class.getDeclaredMethods();
        for (Method o : methods) {
            System.out.println(o.getReturnType() + " ||| " + o.getName() + " ||| " + Arrays.toString(o.getParameterTypes()));
        }
        try {
            Method m1 = Cat.class.getMethod("jump", int.class);
            Method m2 = Cat.class.getMethod("meow", int.class);
            System.out.println(m1 + " | " + m2);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        //Java Reflection позволяет динамически вызвать метод,
        // даже если во время компиляции его имя было неизвестно.
        Cat cat = new Cat("Barsik");
        try {
            Method mMeow = Cat.class.getDeclaredMethod("meow", int.class);
            mMeow.invoke(cat, 5);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println("----------------------------");
        System.out.println("Создание объектов");
        /**
         * Метод newInstance() позволяет создавать экземпляры класса через объект типа Class
         * и возвращает объект типа Object. Если этот метод вызван у объекта типа Class,
         * то для создания нового объекта используется конструктор по умолчанию.
         * Если он отсутствует – будет брошено исключение. Если вначале получаем объект
         * типа Constructor с заданным набором параметров, то newInstance() использует этот набор.
         */
        try {
            Class someClass = Cat.class;
            Constructor catCounstructor = Cat.class.getConstructor(String.class, String.class, int.class);
            Cat cat1 = (Cat)someClass.newInstance();
            Cat cat2 = (Cat)catCounstructor.newInstance("Murzik", "Black", 3);
            System.out.println(cat1.name+" "+cat1.color+" " +cat1.age);
            System.out.println(cat2.name+" "+cat2.color+" " +cat2.age);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
