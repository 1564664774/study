package com.zqh;

import org.junit.Test;

/**
 * @author zhuangqinghui
 * @version 1.0
 * @date 2020/12/16 21:05
 */
public class MyTest {

    @Test
    public void StringTest() {
        String s = "java java helloWord";
        String replace = s.replaceAll("java", "zqh");
        System.out.println(replace);
    }

    @Test
    public void StringTest2() {
        String s = ",1111,";
        String[] split = s.split(",");
        System.out.println(split.length);
    }
}
