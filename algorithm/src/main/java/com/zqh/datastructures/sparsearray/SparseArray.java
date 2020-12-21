package com.zqh.datastructures.sparsearray;

import com.zqh.datastructures.sparsearray.pojo.Item;
import com.zqh.datastructures.sparsearray.pojo.Random;

import java.util.*;

/**
 * @author zhuangqinghui
 * @version 1.0
 * @date 2020/12/18 14:42
 */
public class SparseArray {


    private static final int row = 100;
    private static final int count = 7;

    public static void main(String[] args) {

        int[][] arr = new int[row][row];

        random(arr);
        long l = System.currentTimeMillis();
        int[][] sparseArr = toSparseArr(arr);
        //printArr(sparseArr);

        //List<Item> list = toSparseList(arr);
        //printList(list);

        System.out.println(System.currentTimeMillis() - l);
    }

    public static void printList(List<Item> list) {
        for (Item item : list) {
            System.out.printf("%d\t%d\t%d\n", item.getRow(), item.getCol(), item.getVal());
        }
    }

    public static List<Item> toSparseList(int[][] arr) {
        int sum = 0;
        LinkedList<Item> sparseList = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    sum++;
                    sparseList.add(new Item(i, j, arr[i][j]));
                }
            }
        }
        sparseList.addFirst(new Item(arr.length, arr[0].length, sum));
        return sparseList;
    }



    public static int[][] toSparseArr(int[][] arr) {
        int sum = 0;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    sum++;
                }
            }
        }
        int[][] sparseArr = new int[sum+1][3];
        sparseArr[0][0] = arr.length;
        sparseArr[0][1] = arr[0].length;
        sparseArr[0][2] = sum;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = arr[i][j];
                }
            }
        }
        return sparseArr;
    }

    public static void printArr(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
    }

    public static void random(int[][] arr) {
        java.util.Random random = new java.util.Random();
        Set<Random> set = new HashSet<>();
        while (set.size() < count) {
            int i1 = random.nextInt(row);
            int i2 = random.nextInt(row);
            set.add(new Random(i1, i2));
            arr[i1][i2] = 1;
        }
        //System.out.println(set);
    }
}
