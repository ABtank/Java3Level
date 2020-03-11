package ru.abramov.lesson7_reflection_api;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionApiClass {
    public String fieldName = null;

    Class myClassOblect = ReflectionApiClass.class;
    Class myClassOblect2;
    {
        try {
            myClassOblect2 = Class.forName("ja.ru.ReflectionApiClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    String fullNameClass = myClassOblect2.getName();
    String fullNameClassSimple = myClassOblect2.getSimpleName();

    int classModifiers = myClassOblect2.getModifiers();
    Package aPackage = myClassOblect2.getPackage();

    Class superClass = myClassOblect2.getSuperclass();

    Class[] interfases = myClassOblect2.getInterfaces();
    Class[] interfasesSuperClass = superClass.getInterfaces();

    Constructor[] constructors = myClassOblect2.getConstructors();
    Constructor constructor;

    {
        try {
            constructor = myClassOblect2.getConstructor(new Class[]{String.class});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    Class[] parameterTypes = constructor.getParameterTypes();

    String object;

    {
        try {
            object = (String) constructor.newInstance(parameterTypes[1]);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    Field[] fields = myClassOblect2.getFields();
    Field field = myClassOblect2.getField("fieldName");
    String fieldNameReturn = field.getName();
    Object fieldType = field.getType();

    Class aClass = SomeObject.class;
    Field getField = aClass.getField("stringName");
    SomeObject instance = new SomeObject();
    Object value = getField.get(instance);
    //

    Method[] methods = myClassOblect2.getMethods();
    Method method = myClassOblect2.getMethod("nameVoid", new Class[]{String.class});






    public ReflectionApiClass() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException {
    }

    class SomeObject{
        String stringName = "";
    }
}
