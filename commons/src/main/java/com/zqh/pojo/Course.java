package com.zqh.pojo;

import lombok.Data;

/**
 * @author zhuangqinghui
 * @version 1.0
 * @date 2021/1/4 15:07
 */
@Data
public class Course {
    private Long cid;
    private String cname;
    private Long userId;
    private String cstatus;

    @Override
    public String toString() {
        return "Course{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", userId=" + userId +
                ", cstatus='" + cstatus + '\'' +
                '}';
    }
}
