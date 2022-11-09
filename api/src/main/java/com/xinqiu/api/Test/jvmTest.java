package com.xinqiu.api.Test;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class jvmTest {

    public static void main(String[] args) {


    }







    @Test
    public void jvmTest(){
        List list = new ArrayList();
        for (int i = 0; i < 3000; i++) {
            list.add(new byte[1024 * 1024]);
        }
        System.out.println(list.size());
    }
}
