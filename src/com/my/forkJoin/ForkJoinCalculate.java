package com.my.forkJoin;

import java.util.concurrent.RecursiveTask;

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
}
