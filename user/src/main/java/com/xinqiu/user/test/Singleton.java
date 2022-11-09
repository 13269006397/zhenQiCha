package com.xinqiu.user.test;

public class Singleton {

    private static Singleton singleton;

    private Singleton(){}

    public static Singleton getInstance(){
        if (singleton == null){
             synchronized (Singleton.class){
                 Singleton singleton = new Singleton();
            }
        }
        return singleton;
    }



}
