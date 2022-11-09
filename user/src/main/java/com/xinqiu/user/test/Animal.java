package com.xinqiu.user.test;

import org.apache.commons.lang.StringUtils;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 抽象类
 */
public abstract class Animal{

    public void sleep(){
        System.out.println("我趴着睡");
    }

    // 抽象方法
    public abstract void eat();




    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();

        try {
            lock.lock();
            int a = 1;
            int b = 2;
            System.out.println(a + b);
        }catch (Exception e){
            System.out.println(e);
        }finally {
           lock.unlock();
            System.out.println(lock + "解锁了");

        }











    }

}