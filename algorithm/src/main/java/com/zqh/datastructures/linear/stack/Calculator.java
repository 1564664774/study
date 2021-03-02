package com.zqh.datastructures.linear.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 利用栈实现综合计算器
 *
 * @author zhuangqinghui
 * @version 1.0
 * @date 2021/2/20 14:39
 */
public class Calculator {

    private static final Set<Character> operSet = new HashSet<>();

    static {
        operSet.add('+');
        operSet.add('-');
        operSet.add('*');
        operSet.add('/');
    }


    public static void main(String[] args) {
        String expression = "3+2*6-2";

        Stack<Integer> numStack = new Stack<>();
        Stack<Character> operStack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            //判断是不是符号
            if (isOper(c)) {
                //如果是符号
                //栈空或者符号优先级小于栈顶的直接入栈
                if (operStack.isEmpty() || priority(operStack.peek()) < priority(c)) {
                    operStack.push(c);
                } else {
                    // 如果此时符号优先级小于栈顶优先级,  进行计算
                    numStack.push(cal(numStack.pop(), numStack.pop(), operStack.pop()));
                    i--;
                }
            } else {
                numStack.push(c - '0');
            }
        }
        System.out.println(cal(numStack.pop(), numStack.pop(), operStack.pop()));
    }


    public static int priority(char oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //判断是不是运算符
    public static boolean isOper(char oper) {
        return operSet.contains(oper);
    }


    public static int cal(int num1, int num2, char oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
        }
        return res;
    }
}
