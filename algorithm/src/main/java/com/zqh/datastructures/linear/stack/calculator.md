# 利用栈实现计算器

## 第一版代码

```java
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
        while (!operStack.isEmpty()) {
            numStack.push(cal(numStack.pop(), numStack.pop(), operStack.pop()));
        }
        System.out.println(numStack.pop());
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
```

> 第一版代码, 只能实现简单的计算, 首先只能是个位的运算, 如果数字超过一位数就会计算错误, 第二个问题就是如果加括号就会有问题

## 第二版, 我们重点解决括号的问题

1. 我们需要明确, 如果说有括号, 那么当我们遇到左括号的时候直接入栈
2. 在遇到右括号之前和前面的算法是一样的, 判断优先级, 进行计算.
3. 如果遇到了右括号, 弹出符号栈进行计算, 知道符号栈弹出左括号, 结束.
4. 继续原来的算法往下

所以我们修改之后的代码是这样的

```java
public class Calculator {

    private static final Set<Character> operSet = new HashSet<>();

    static {
        operSet.add('+');
        operSet.add('-');
        operSet.add('*');
        operSet.add('/');
        operSet.add('(');
        operSet.add(')');
    }


    public static void main(String[] args) {
        String expression = "3+2*((6-2)*2)";

        Stack<Integer> numStack = new Stack<>();
        Stack<Character> operStack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            //判断是不是符号
            if (isOper(c)) {
                //如果是符号
                //栈空或者符号优先级小于栈顶的直接入栈
                if (operStack.isEmpty() || priority(operStack.peek()) < priority(c) || c == '(') {
                    operStack.push(c);
                } else {
                    if (c == ')') {
                        // 如果是右括号, 则计算到左括号停止
                        char oper;
                        while ((oper = operStack.pop()) != '(') {
                            numStack.push(cal(numStack.pop(), numStack.pop(), oper));
                        }
                    } else {
                        // 如果此时符号优先级小于栈顶优先级,  进行计算
                        numStack.push(cal(numStack.pop(), numStack.pop(), operStack.pop()));
                        i--;
                    }
                }
            } else {
                numStack.push(c - '0');
            }
        }
        while (!operStack.isEmpty()) {
            numStack.push(cal(numStack.pop(), numStack.pop(), operStack.pop()));
        }
        System.out.println(numStack.pop());
    }


    public static int priority(char oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else if (oper == '('){
            return -1;
        } else {
            return -1000;
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
```

## 解决多位数的问题

1. 解决多位数, 我们需要记录上一个字符是否为数字. 如果为数字需要进行*10之后累加.
2. 直到出现的字符不是数字;
3. 我们定义一个num来记录之前累加的数, 和一个标记判断前面是不是数字

```java
public class Calculator {

    private static final Set<Character> operSet = new HashSet<>();

    static {
        operSet.add('+');
        operSet.add('-');
        operSet.add('*');
        operSet.add('/');
        operSet.add('(');
        operSet.add(')');
    }


    public static void main(String[] args) {
        String expression = "3+2*((16-12)*2)";

        Stack<Integer> numStack = new Stack<>();
        Stack<Character> operStack = new Stack<>();
        int num = 0;
        boolean lastIsNum = false;
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            //判断是不是符号
            if (isOper(c)) {
                if (lastIsNum) {
                    numStack.push(num);
                    num = 0;
                    lastIsNum = false;
                }
                //如果是符号
                //栈空或者符号优先级小于栈顶的直接入栈
                if (operStack.isEmpty() || priority(operStack.peek()) < priority(c) || c == '(') {
                    operStack.push(c);
                } else {
                    if (c == ')') {
                        // 如果是右括号, 则计算到左括号停止
                        char oper;
                        while ((oper = operStack.pop()) != '(') {
                            numStack.push(cal(numStack.pop(), numStack.pop(), oper));
                        }
                    } else {
                        // 如果此时符号优先级小于栈顶优先级,  进行计算
                        numStack.push(cal(numStack.pop(), numStack.pop(), operStack.pop()));
                        i--;
                    }
                }
            } else {
                //numStack.push(c - '0');
                lastIsNum = true;
                num = num * 10 + (c - '0');
            }
        }
        while (!operStack.isEmpty()) {
            numStack.push(cal(numStack.pop(), numStack.pop(), operStack.pop()));
        }
        System.out.println(numStack.pop());
    }


    public static int priority(char oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else if (oper == '('){
            return -1;
        } else {
            return -1000;
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
```

> 后面还有负数的问题, 就不解决了, 以及其它运算符号都可以试试
