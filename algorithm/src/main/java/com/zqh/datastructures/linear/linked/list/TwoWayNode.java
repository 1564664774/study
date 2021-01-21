package com.zqh.datastructures.linear.linked.list;

import lombok.Data;

/**
 * @author zhuangqinghui
 * @version 1.0
 * @date 2021/1/20 18:10
 */
@Data
public class TwoWayNode {
    private int no;
    private String name;
    private String nickName;
    private TwoWayNode pre;
    private TwoWayNode next;


    public TwoWayNode() {
    }

    public TwoWayNode(int no, String name, String nickName) {
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
