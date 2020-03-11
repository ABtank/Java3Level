package ru.abramov.lesson7_reflection_api;

import java.lang.reflect.Field;

public class PrivateClass {
    private String mPrivateString = null;
    private int anInt = 5;

    public String getmPrivateString() {
        return mPrivateString;
    }

    public void setmPrivateString(String mPrivateString) {
        this.mPrivateString = mPrivateString;
    }

    public PrivateClass(String mPrivateString) throws NoSuchFieldException {
        this.mPrivateString=mPrivateString;
    }

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        PrivateClass privateClass = new PrivateClass("security");

        Field privateStringField = PrivateClass.class.getDeclaredField("mPrivateString");
        privateStringField.setAccessible(true);
        String getSecurity = privateClass.getmPrivateString();
        String fieldValue = (String) privateStringField.get(privateClass);

        Field privateIntField = PrivateClass.class.getDeclaredField("anInt");
        privateIntField.setAccessible(true);
        int seven = (Integer) privateIntField.get(privateClass)+2;
        System.out.println(seven);
    }
}
