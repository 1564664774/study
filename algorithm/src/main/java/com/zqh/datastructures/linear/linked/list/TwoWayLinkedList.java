package com.zqh.datastructures.linear.linked.list;

import java.util.Stack;

/**
 * @author zhuangqinghui
 * @version 1.0
 * @date 2021/1/20 18:09
 */
public class TwoWayLinkedList {
    // 头结点
    private TwoWayNode head = new TwoWayNode();

    //添加节点
    public void add(TwoWayNode node) {
        TwoWayNode temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        node.setPre(temp);
        temp.setNext(node);
    }

    //根据编号顺序插入节点, 如果编号相同提示
    public void addByOrder(TwoWayNode node) {
        TwoWayNode temp = head;
        while (temp.getNext() != null && temp.getNext().getNo() <= node.getNo()) {
            temp = temp.getNext();
        }
        if (temp.getNo() == node.getNo()) {
            System.out.println("节点已存在");
            return;
        }
        node.setPre(temp.getPre());
        node.setNext(temp.getNext());
        temp.getPre().setNext(node);
        temp.setPre(node);
        temp.setNext(node);
    }

    //根据no修改节点
    public void modify(TwoWayNode node) {
        TwoWayNode temp = head.getNext();
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
        TwoWayNode temp = head;
        while (temp != null && temp.getNo() != no) {
            temp = temp.getNext();
        }
        if (temp == null) {
            System.out.println("没有该节点");
            return;
        }
        temp.getNext().setPre(temp.getPre());
        temp.getPre().setNext(temp.getNext());
    }



    //遍历链表
    public void print() {
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        TwoWayNode temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
            System.out.println(temp);
        }
    }




    public static void main(String[] args) {
    }

    public static void text1() {
        TwoWayLinkedList list = new TwoWayLinkedList();
        TwoWayNode node1 = new TwoWayNode(1, "宋江", "及时雨");
        TwoWayNode node2 = new TwoWayNode(2, "卢俊义","玉麒麟");
        TwoWayNode node3 = new TwoWayNode(3, "吴用", "智多星");
        TwoWayNode node4 = new TwoWayNode(4, "林冲", "豹子头");
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        list.print();
    }
    public static void text2() {
        TwoWayLinkedList list = new TwoWayLinkedList();
        TwoWayNode node1 = new TwoWayNode(1, "宋江", "及时雨");
        TwoWayNode node2 = new TwoWayNode(2, "卢俊义","玉麒麟");
        TwoWayNode node3 = new TwoWayNode(3, "吴用", "智多星");
        TwoWayNode node4 = new TwoWayNode(4, "林冲", "豹子头");
        list.addByOrder(node1);
        list.addByOrder(node3);
        list.addByOrder(node2);
        list.addByOrder(node4);
        list.print();
    }
    public static void text3() {
        TwoWayLinkedList list = new TwoWayLinkedList();
        TwoWayNode node1 = new TwoWayNode(1, "宋江", "及时雨");
        TwoWayNode node2 = new TwoWayNode(2, "卢俊义","玉麒麟");
        TwoWayNode node3 = new TwoWayNode(3, "吴用", "智多星");
        TwoWayNode node4 = new TwoWayNode(4, "林冲", "豹子头");
        list.addByOrder(node1);
        list.addByOrder(node3);
        list.addByOrder(node2);
        list.addByOrder(node4);
        list.print();
        list.modify(new TwoWayNode(6, "111", "修改后"));
        System.out.println("修改后的情况~~~~~~~~");
        list.print();
    }

    public static void text4() {
        TwoWayLinkedList list = new TwoWayLinkedList();
        TwoWayNode node1 = new TwoWayNode(1, "宋江", "及时雨");
        TwoWayNode node2 = new TwoWayNode(2, "卢俊义","玉麒麟");
        TwoWayNode node3 = new TwoWayNode(3, "吴用", "智多星");
        TwoWayNode node4 = new TwoWayNode(4, "林冲", "豹子头");
        list.addByOrder(node1);
        list.addByOrder(node3);
        list.addByOrder(node2);
        list.addByOrder(node4);
        list.print();
        list.delete(6);
        System.out.println("修改后的情况~~~~~~~~");
        list.print();
    }
}
