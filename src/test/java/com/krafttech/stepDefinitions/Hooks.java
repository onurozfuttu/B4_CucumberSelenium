package com.krafttech.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void setUp(){
        System.out.println("This is coming from before method");
    }

    @After
    public void tearDown(){
        System.out.println("This is coming from after method");
    }

    @Before(order = 1, value = "@database")
    public void openDataBase(){
        System.out.println("Open database");
    }

    @After(order = 1, value = "@database")
    public void closeDataBase(){
        System.out.println("Close database");
    }
}
