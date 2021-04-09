package com.zqh;

import com.zqh.pojo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zhuangqinghui
 * @version 1.0
 * @date 2021/4/5 16:08
 */
public class StreamTest {

    User[] arr;

    @BeforeEach
    public void before() {


    }
    @AfterEach
    public  void after() {
    }

    @Test
    public void toList() {
        String[] arr = new String[]{"11", "22", "33", "44", "55", "33"};
        Set<String> list = Arrays.stream(arr).collect(Collectors.toSet());
        System.out.println(list);
    }

}
