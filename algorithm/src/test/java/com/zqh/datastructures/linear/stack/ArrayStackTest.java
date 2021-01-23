package com.zqh.datastructures.linear.stack;

import org.junit.Test;

import java.util.Scanner;


public class ArrayStackTest {


    @Test
    public void stackTest() {
        ArrayStack stack = new ArrayStack(4);
        String key = "";
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