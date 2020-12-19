package com.zqh.datastructures.sparsearray.pojo;

import lombok.Data;

/**
 * @author zhuangqinghui
 * @version 1.0
 * @date 2020/12/18 16:53
 */
@Data
public class Item {
    private Integer row;
    private Integer col;
    private Integer val;

    public Item() {
    }

    public Item(Integer row, Integer col, Integer val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}
