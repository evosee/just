package com.my.huawei;

import java.util.Stack;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/6/21 16:46
 */
public class Queue {

    private Stack<Integer> pushStack = new Stack<>();
    private Stack<Integer> popStack = new Stack<>();

    public void push(Integer integer){
        pushStack.push(integer);
    }

    public Integer pop(){
        if(!popStack.isEmpty()){
            return popStack.pop();
        }
        while (!pushStack.isEmpty()){
            Integer i = pushStack.pop();
            popStack.push(i);
        }
        if(!popStack.isEmpty()){
            return popStack.pop();
        }
        return null;

    }
    public boolean isEmpty(){
        return pushStack.isEmpty()&&popStack.isEmpty();
    }

}
