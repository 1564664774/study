package com.zqh.datastructures.linear.queue;

/**
 * 使用数组模拟队列
 *
 * @author zhuangqinghui
 * @version 1.0
 * @date 2020/12/24 16:45
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        /*ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.addQueue(1);
        arrayQueue.addQueue(2);
        arrayQueue.addQueue(3);
        try {
            arrayQueue.addQueue(4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        arrayQueue.showQueue();
        System.out.println(arrayQueue.getQueue());
        arrayQueue.showQueue();
        System.out.println(arrayQueue.getQueue());
        arrayQueue.showQueue();
        System.out.println(arrayQueue.getQueue());
        arrayQueue.showQueue();
        try {
            System.out.println(arrayQueue.getQueue());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/


        ArrayQueueAround arrayQueueAround = new ArrayQueueAround(3);
        arrayQueueAround.addQueue(1);
        arrayQueueAround.addQueue(2);
        //arrayQueueAround.addQueue(3);
        try {
            arrayQueueAround.addQueue(4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        arrayQueueAround.showQueue();
        System.out.println(arrayQueueAround.getQueue());
        arrayQueueAround.showQueue();
        System.out.println(arrayQueueAround.getQueue());
        arrayQueueAround.showQueue();
        //System.out.println(arrayQueueAround.getQueue());
        //arrayQueueAround.showQueue();
        try {
            System.out.println(arrayQueueAround.getQueue());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class ArrayQueue {

    private final int maxSize; //长度
    private int front;  //队列头
    private int rear;   //队列尾
    private final int[] arr;

    public ArrayQueue(int maxSize) {
        this.front = -1;
        this.rear = -1;
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    //队列判空
    public boolean isEmpty() {
        return front == rear;  //当头等于尾的时候等于空
    }

    //队列是否满了
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //插入数据
    public void addQueue(int item) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        arr[++rear] = item;
    }

    //取出数据
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列中没有数据");
        }
        return arr[++front];
    }

    //显示所有数据
    public void showQueue() {
        for (int i = front + 1; i <= rear; i++) {
            System.out.printf("%d\t", arr[i]);
        }
        System.out.println();
    }

}

/**
 * 循环队列重要的是留一个位置作为约定空间, 这样才能判断空还是满
 *
 * @author zhuangqinghui
 * @date 2021/1/11
 */
class ArrayQueueAround {

    private final int maxSize; //长度
    private int front;  //队列头
    private int rear;   //队列尾
    private final int[] arr;

    public ArrayQueueAround(int maxSize) {
        this.front = 0;
        this.rear = 0;
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    //队列判空
    public boolean isEmpty() {
        return front == rear;  //当头等于尾的时候等于空
    }

    //队列是否满了
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //插入数据
    public void addQueue(int item) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        arr[rear] = item;
        rear = ++rear % maxSize;
    }

    //取出数据
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列中没有数据");
        }
        int temp = arr[front];
        front = (front + 1) % maxSize;
        return temp;
    }

    //显示所有数据
    public void showQueue() {
        for (int i = front; i != rear; i = (i + 1) % maxSize) {
            System.out.printf("%d\t", arr[i]);
        }
        System.out.println();
    }

}