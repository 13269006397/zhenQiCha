package com.xinqiu.user.test;

import java.util.HashMap;

class Thread2 implements Runnable{
    private String name;

    public Thread2(String name) {
        this.name=name;
    }

    @Override
    public void run() {
        int i = 5;
        for (int i1 = 0; i1 < i; i1++) {
            System.out.println(name + "运行  :  " + i1);
            HashMap<String, String> map = new HashMap<>();
            map.put("key", "value");
        }
    }
}

public class Main {

    public static void main(String[] args) {
        new Thread(new Thread2("C")).start();
        new Thread(new Thread2("D")).start();
    }

}