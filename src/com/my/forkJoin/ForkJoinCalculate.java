package com.my.forkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkJoinCalculate extends RecursiveTask<Long> {

    private long[] numbers;
    private int start;
    private int end;
    private static final int THRESHOLD = 1000;

    public ForkJoinCalculate(long[] numbers,int start,int end){
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }
    @Override
    protected Long compute() {
        int length = end-start;
        if(length<THRESHOLD){
            return computeSequce();
        }
        ForkJoinCalculate left = new ForkJoinCalculate(numbers,start,length/2);
        left.fork();
        ForkJoinCalculate right = new ForkJoinCalculate(numbers,start+length/2,end);
        long r = right.compute();
        long l = left.join();
        return r+l;
    }

    private long computeSequce() {
        long result=0;
        for(int i=start;i<end;i++) result+=numbers[i];
        return result;
    }

    public static void main(String[] args) {
        long[] a = LongStream.rangeClosed(1,100000000).toArray();
        ForkJoinCalculate forkJoinCalculate = new ForkJoinCalculate(a,0,a.length);
        ForkJoinTask r = ForkJoinPool.commonPool().submit(forkJoinCalculate);
       // long r  =   ForkJoinPool.commonPool().invoke(forkJoinCalculate);
        try {
            System.out.println(r.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
