package com.zqh;

import com.zqh.datastructures.sparsearray.pojo.Random;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

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

        //String[] split = s.split(",");
        //System.out.println(split.length);

    }

    @Test
    public void randomTest() {
        java.util.Random random = new java.util.Random();
        Set<Random> set = new HashSet<>();
        while (set.size() < 100) {
            int i1 = random.nextInt(10);
            int i2 = random.nextInt(10);
            set.add(new Random(i1, i2));
        }
        System.out.println(set);
    }
}
