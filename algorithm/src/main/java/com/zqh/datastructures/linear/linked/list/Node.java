package com.zqh.datastructures.linear.linked.list;


import lombok.Data;

/**
 * @author zhuangqinghui
 * @version 1.0
 * @date 2021/1/17 14:36
 */
@Data
public class Node {

    private int no;
    private String name;
    private String nickName;
    private Node next;


    public Node() {
    }

    public Node(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
