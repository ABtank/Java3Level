package ru.abramov.lesson7_reflection_api;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ClassIsTrue {

    static void setFinalStatic(Field field, Object newValue) throws Exception {
        field.setAccessible(true);
        Field modifierField = Field.class.getDeclaredField("modifiers");
        modifierField.setAccessible(true);
        modifierField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

        field.set(null,newValue);
    }

    public static void main(String[] args) throws Exception {
        setFinalStatic(Boolean.class.getField("FALSE"),true);
        System.out.format("Все у нас %s", 2==5);
        System.out.format("Все у нас %s", 5==5);

    }
}
