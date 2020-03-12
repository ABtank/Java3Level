package ru.abramov.lesson7_reflection_api.home_work;

public class ClassTest extends Thread {

    @TestSuite(priority = 6)
    public void test1(){

    }

    @TestSuite(priority = 7)
    public void test2(){

    }
    @TestSuite(priority = 8)
    public void test3(){

    }

    @BeforeSuite()
    public void init(){

    }

    @AfterSuite()
    public void clear(){

    }
}
