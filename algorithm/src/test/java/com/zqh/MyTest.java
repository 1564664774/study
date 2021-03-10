package com.zqh;

import com.alibaba.fastjson.JSONObject;
import com.zqh.datastructures.sparsearray.pojo.Random;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    public void StringTest2() throws ParseException {

        //String[] split = s.split(",");
        //System.out.println(split.length);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2021-01-27");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DATE, -1);
        System.out.println(format.format(cal.getTime()));

    }

    @Test
    public void ListTest() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.subList(1, 3).clear();
        System.out.println(JSONObject.toJSONString(list));
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
        int[] nums = new int[]{-8, -7, -2, 10, 20};
        //
        //保存负数数组
        int[] negativeNumber = new int[]{0, 0};
        //{0, 0}
        //保存正数数组
        int[] positiveNumber = new int[]{-1, -1, -1};
        //{-1, -1, -1}
        if (nums.length == 3) {
            System.out.println(nums[0] * nums[1] * nums[2]);
            return;
        }
        for (int num : nums) {
            if (num < 0) {
                if (num > negativeNumber[negativeNumber.length - 1]) {
                    continue;
                }
                for (int i = negativeNumber.length - 2; i >= 0; i--) {
                    if (num < negativeNumber[i]) {
                        negativeNumber[i + 1] = negativeNumber[i];
                        if (i == 0) {
                            negativeNumber[i] = num;
                        }
                    } else {
                        negativeNumber[i + 1] = num;
                        break;
                    }
                }
            } else {
                if (num < positiveNumber[positiveNumber.length - 1]) {
                    continue;
                }
                for (int i = positiveNumber.length - 2; i >= 0; i--) {
                    if (num > positiveNumber[i]) {
                        positiveNumber[i + 1] = positiveNumber[i];
                        if (i == 0) {
                            positiveNumber[i] = num;
                        }
                    } else {
                        positiveNumber[i + 1] = num;
                    }
                }
            }
        }

        if (positiveNumber[0] * positiveNumber[1] * positiveNumber[2] < 0) {
            System.out.println(positiveNumber[0] * positiveNumber[1] * positiveNumber[0]);
        } else if (negativeNumber[0] * negativeNumber[1] != 0) {
            if (negativeNumber[0] * negativeNumber[1] > positiveNumber[0] * positiveNumber[1]) {
                System.out.println(negativeNumber[0] * negativeNumber[1] * positiveNumber[0]);
            } else {
                System.out.println(positiveNumber[0] * positiveNumber[1] * positiveNumber[2]);
            }
        } else {
            System.out.println(positiveNumber[0] * positiveNumber[1] * positiveNumber[2]);
        }

    }

    /**
     * 一个数组的和
     *
     * @return
     * @author zhuangqinghui
     * @date 2021/1/27
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer integer = map.get(num);
            if (integer == null) {
                map.put(target - num, i);
            } else {
                return new int[]{integer, i};
            }
        }
        return new int[2];
    }

    @Test
    public void twoSumTest() {
        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        LinkedList<Character> list = new LinkedList<>();
        for (char c : s.toCharArray()) {
            int i = list.indexOf(c);
            if (i != -1) {
                list.subList(0, i + 1).clear();
                list.add(c);
            } else {
                list.add(c);
                maxLength = Math.max(maxLength, list.size());
            }
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring2(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    @Test
    public void lengthOfLongestSubstringTest() {
        System.out.println(lengthOfLongestSubstring2("aab"));
    }


    /**
     * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
     *
     * @param nums1
     * @param nums2
     * @return double
     * @author zhuangqinghui
     * @date 2021/2/5
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0;
        int i = 0;
        int j = 0;
        int length = nums1.length + nums2.length;
        int centre = (nums1.length + nums2.length - 1) / 2;
        while (i < nums1.length || j < nums2.length) {
            if (i + j >= centre) {
                if (length % 2 == 1) {
                    if (i == nums1.length) {
                        result = nums2[j];
                    } else if (j == nums2.length) {
                        result = nums1[i];
                    } else {
                        result = Math.min(nums1[i], nums2[j]);
                    }
                    return result;
                } else {
                    if (i + j == centre) {
                        if (i == nums1.length) {
                            result = nums2[j];
                        } else if (j == nums2.length) {
                            result = nums1[i];
                        } else {
                            result = Math.min(nums1[i], nums2[j]);
                        }
                    } else {
                        if (i == nums1.length) {
                            result = (result + nums2[j]) / 2;
                        } else if (j == nums2.length) {
                            result = (result + nums1[i]) / 2;
                        } else {
                            result = (result + Math.min(nums1[i], nums2[j])) / 2;
                        }
                        return result;
                    }
                }
            }
            //如果1 > 2 取一
            if (i != nums1.length && (j == nums2.length || nums1[i] < nums2[j])) {
                i++;
            } else {
                j++;
            }
        }
        return result;
    }

    @Test
    public void findMedianSortedArraysTest() {
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{2, 3};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
