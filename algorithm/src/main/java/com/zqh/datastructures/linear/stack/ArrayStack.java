package com.zqh.datastructures.linear.stack;

import lombok.Data;

import java.util.Scanner;


/**
 * @author zhuangqinghui
 * @version 1.0
 * @date 2021/1/22 10:06
 */
@Data
public class ArrayStack {

    private int maxSize;        //栈的大小
    private int[] stack;        //数组模拟栈
    private int top = -1;       //top表示栈顶栈为空时为-1

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }


    //判断栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public boolean push(int value) {
        if (isFull()) {
            System.out.println("栈满\n");
            return false;
        }
        stack[++top] = value;
        return true;
    }

    //出栈
    public int pop() throws RuntimeException {
        //判断栈空
        if (isEmpty()) {
            throw new RuntimeException("栈空\n");
        }
        return stack[top--];
    }

    //遍历栈
    public void print() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("%d\t", stack[i]);
        }
        System.out.println();
    }


    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        String key;
        boolean loop = true;
        Scanner input = new Scanner(System.in);
        while (loop) {
            System.out.println("show: 显示栈");
            System.out.println("exit: 退出");
            System.out.println("push: 入栈");
            System.out.println("pop: 出栈");
            System.out.println("请输入你的选择: ");
            key = input.next();
            switch (key) {
                case "show":
                    stack.print();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = input.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        System.out.println(stack.pop());
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    input.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}


