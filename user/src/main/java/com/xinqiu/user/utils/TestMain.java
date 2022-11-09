package com.xinqiu.user.utils;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestMain{
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newCachedThreadPool();
        ArrayList<Future> futures = new ArrayList<>();


        sumIndex subIndex1 = new sumIndex(2, 4);
        Future<Integer> submit1 = executor.submit(subIndex1);
        futures.add(submit1);

        sumIndex subIndex2 = new sumIndex(25, 4);
        Future<Integer> submit2 = executor.submit(subIndex2);
        System.out.println("线程2" + submit2);
        futures.add(submit2);

        executor.shutdown();



        for(Future<Integer> future : futures){
            while(true){
                if(future.isDone() && !future.isCancelled()){
                    int sum = future.get();
                    System.out.println(sum);
                    break;
                }
                else{
                    Thread.sleep(100);
                }
            }
        }

    }



}

class sumIndex implements Callable<Integer>{
    private int min;
    private int max;

    public sumIndex(int min, int max){
        this.min = min;
        this.max = max;
    }


    @Override
    public Integer call() throws Exception {
        int sum = min + max;
        return sum;
    }
}