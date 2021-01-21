package com.zqh;

import com.zqh.datastructures.sparsearray.pojo.Random;
import org.apache.commons.lang3.ArrayUtils;
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

    /**
     * 获取一个数组里面最大三个数的乘积
     *
     * @param
     * @return void
     * @author zhuangqinghui
     * @date 2021/1/20
     */
    @Test
    public void maximumProduct() {
        int[] nums = new int[]{1, 2, 4, 4, 5, -1, 2, 6, 7};
        //
        //保存负数数组
        int[] negativeNumber = new int[]{0, 0};
        //{0, 0}
        //保存正数数组
        int[] positiveNumber = new int[]{-1, -1, -1};
        //{-1, -1, -1}
        if (nums.length == 3) {
            System.out.println(nums[0]*nums[1]*nums[2]);
            return;
        }
        for (int num : nums) {
            if (num < 0) {
                if (num > negativeNumber[negativeNumber.length-1]) {
                    continue;
                }
                for (int i = negativeNumber.length - 2; i >= 0; i--) {
                    if (num < nums[i]) {
                        negativeNumber[i+1] = negativeNumber[i];
                        if (i == 0) {
                            negativeNumber[i] = num;
                        }
                    } else {
                        negativeNumber[i+1] = num;
                        break;
                    }
                }
            } else {
                if (num < positiveNumber[positiveNumber.length-1]) {
                    continue;
                }
                for (int i = positiveNumber.length - 2; i >= 0; i--) {
                    if (num > nums[i]) {
                        positiveNumber[i+1] = positiveNumber[i];
                        if (i == 0) {
                            positiveNumber[i] = num;
                        }
                    } else {
                        positiveNumber[i+1] = num;
                    }
                }
            }
        }

        if (negativeNumber[0] * negativeNumber[1] != 0) {
            if (negativeNumber[0] * negativeNumber[1] > positiveNumber[0] * positiveNumber[1]) {
                System.out.println(negativeNumber[0] * negativeNumber[1] * positiveNumber[0]);
            } else {
                System.out.println(positiveNumber[0] * positiveNumber[1] * positiveNumber[2]);
            }
        }

    }
}
