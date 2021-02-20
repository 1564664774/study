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

    public static void main(String[] args) {
        String s = "{activityId=2112020120955194&activityNmd=住店圈单品立减TEST&discountAmt=1&mchtDiscountAmt=1}";
        System.out.println(getValue(s, "activityId"));
        System.out.println(getValue(s, "activityNmd"));
        System.out.println(getValue(s, "discountAmt"));
        System.out.println(getValue(s, "mchtDiscountAmt"));
        System.out.println(getValue(s, "112"));
        System.out.println(getValue(s, "disco"));
        System.out.println(getValue(s, "d"));
    }

    public static String getValue(String str, String name) {
        int i = -1;
        Character flag = ' ';
        name = name + "=";
        while (!flag.equals('{') && !flag.equals('&')) {
            i = str.indexOf(name, i + 1);
            if (i == -1) {
                break;
            }
            flag = str.charAt(i - 1);
        }
        if (i == -1) {
            return "";
        }
        int j = str.indexOf("&", i);
        if (j == -1) {
            return str.substring(i + name.length(), str.length() - 1);
        } else {
            return str.substring(i + name.length(), j);
        }
    }
}
