package com.zqh.datastructures.linear.linked.list;

import lombok.Data;

import java.util.Stack;

/**
 * @author zhuangqinghui
 * @version 1.0
 * @date 2021/1/17 14:51
 */
@Data
public class SingleLinkedList {

    // 头结点
    private Node head = new Node();

    //添加节点
    public void add(Node node) {
        Node temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(node);
    }

    //根据编号顺序插入节点, 如果编号相同提示
    public void addByOrder(Node node) {
        Node temp = head;
        while (temp.getNext() != null && temp.getNext().getNo() <= node.getNo()) {
            temp = temp.getNext();
        }
        if (temp.getNo() == node.getNo()) {
            System.out.println("节点已存在");
            return;
        }
        node.setNext(temp.getNext());
        temp.setNext(node);
    }

    //根据no修改节点
    public void modify(Node node) {
        Node temp = head.getNext();
        while (temp != null && temp.getNo() != node.getNo()) {
            temp = temp.getNext();
        }
        if (temp == null) {
            System.out.println("找不到该节点");
            return;
        }
        temp.setName(node.getName());
        temp.setNickName(node.getNickName());
    }

    //删除节点
    public void delete(int no) {
        Node temp = head;
        while (temp.getNext() != null && temp.getNext().getNo() != no) {
            temp = temp.getNext();
        }
        if (temp.getNext() == null) {
            System.out.println("没有该节点");
            return;
        }
        temp.setNext(temp.getNext().getNext());
    }

    //链表反转, 重点在于保存下一个链表的指针
    public void reverse() {
        SingleLinkedList reList = new SingleLinkedList();
        Node node = this.head.getNext();
        while (node != null) {
            Node temp = node;
            node = node.getNext();
            temp.setNext(reList.head.getNext());
            reList.head.setNext(temp);
        }
        head = reList.head;
    }

    //遍历链表
    public void print() {
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        Node temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
            System.out.println(temp);
        }
    }


    public static void main(String[] args) {
        text5();
        Stack<String> stack = new Stack<>();
    }

    public static void text1() {
        SingleLinkedList list = new SingleLinkedList();
        Node node1 = new Node(1, "宋江", "及时雨");
        Node node2 = new Node(2, "卢俊义", "玉麒麟");
        Node node3 = new Node(3, "吴用", "智多星");
        Node node4 = new Node(4, "林冲", "豹子头");
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        list.print();
    }

    public static void text2() {
        SingleLinkedList list = new SingleLinkedList();
        Node node1 = new Node(1, "宋江", "及时雨");
        Node node2 = new Node(2, "卢俊义", "玉麒麟");
        Node node3 = new Node(3, "吴用", "智多星");
        Node node4 = new Node(4, "林冲", "豹子头");
        list.addByOrder(node1);
        list.addByOrder(node3);
        list.addByOrder(node2);
        list.addByOrder(node4);
        list.print();
    }

    public static void text3() {
        SingleLinkedList list = new SingleLinkedList();
        Node node1 = new Node(1, "宋江", "及时雨");
        Node node2 = new Node(2, "卢俊义", "玉麒麟");
        Node node3 = new Node(3, "吴用", "智多星");
        Node node4 = new Node(4, "林冲", "豹子头");
        list.addByOrder(node1);
        list.addByOrder(node3);
        list.addByOrder(node2);
        list.addByOrder(node4);
        list.print();
        list.modify(new Node(6, "111", "修改后"));
        System.out.println("修改后的情况~~~~~~~~");
        list.print();
    }

    public static void text4() {
        SingleLinkedList list = new SingleLinkedList();
        Node node1 = new Node(1, "宋江", "及时雨");
        Node node2 = new Node(2, "卢俊义", "玉麒麟");
        Node node3 = new Node(3, "吴用", "智多星");
        Node node4 = new Node(4, "林冲", "豹子头");
        list.addByOrder(node1);
        list.addByOrder(node3);
        list.addByOrder(node2);
        list.addByOrder(node4);
        list.print();
        list.delete(6);
        System.out.println("修改后的情况~~~~~~~~");
        list.print();
    }

    public static void text5() {
        SingleLinkedList list = new SingleLinkedList();
        Node node1 = new Node(1, "宋江", "及时雨");
        Node node2 = new Node(2, "卢俊义", "玉麒麟");
        Node node3 = new Node(3, "吴用", "智多星");
        Node node4 = new Node(4, "林冲", "豹子头");
        list.addByOrder(node1);
        list.addByOrder(node3);
        list.addByOrder(node2);
        list.addByOrder(node4);
        list.print();
        list.reverse();
        System.out.println("修改后的情况~~~~~~~~");
        list.print();
    }

}
