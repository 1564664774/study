# java数据结构与算法一、（稀疏数组）

## 定义

存在一个二维数组大部分是0, 之后少部分有数值的时候我们可以采用稀疏数组存储数据, 节约空间

如:

$$\begin{matrix} &0 &0 & 0 & 22 & 0 & 0 & 15 \\ &0 & 11 & 0 & 0 & 0 & 17 & 0\\ &0 & 0 & 0 & -6 &0 & 0 & 0\\ &0 & 0 & 0 &
0 &0 & 19 & 0\\ &91 &0 & 0 & 0 &0 & 0 & 0\\ &0 & 0 & 28 & 0 &0 & 0 & 0\\ \end{matrix}$$

我们可以存储这样一个稀疏数组表示这个二维数组 |行 | 列 | 值 | | | :----: | :----: | :----: | :----: | |6 | 7 | 8 | 稀疏数组第一行表示, 总的几行几列几个值 | |0 | 3 |
22 | 第二行开始记录每一个数的位置和值 | |0 | 6 | 15| |1 | 1 | 11| |1 | 5 | 17| |2 | 3 | -6| |3 | 5 | 39| |4 | 0 | 91| |5 | 2 | 28|

这样就可以从48到24, 节省一半的空间

## 应用实例

我们以稀疏数组存放棋盘, 并且可以恢复成原来的实例.

### 二维数组转稀疏数组

1. 遍历二维数组得到原始有效个数sum
2. 创建一个稀疏数组 ==arr[ sum+1 ][ 0 ]==
3. 将有效数据存入稀疏数组.

> 这边有一个疑惑如果要先遍历一遍创建数组, 那就得多遍历一遍赋值, 会多遍历一遍.
> 如果是list就没有问题, 为什么不用list

### 稀疏数组转元素二维数组

1. 读取稀疏数组第一行, 根据第一行的值创建二维数组 ==oriArr[ row ][ cal ]==
2. 遍历稀疏数组根据坐标和值放入数据

 ```java
import org.apache.commons.lang3.ArrayUtils;

/**
 * @author zhuangQingHui
 * @version 1.0
 * @date 2020/12/18 14:42
 */
public class SparseArray {

    public static void main(String[] args) {

        int[][] arr = new int[11][11];
        arr[1][1] = 1;
        arr[2][2] = 2;
        int[][] sparseArr = toSparseArr(arr);
        printArr(sparseArr);
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
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%d\t",arr[i][j]);
            }
            System.out.println();
        }
    }
}

 ```

> 从代码上看确实循环了两遍, 所以我想用list再试一遍.

```java
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
```

> 重新写一个转换为list的方法, 并将数组改为万级别的数据

``` java
package com.zqh.datastructures.sparsearray;

import com.zqh.datastructures.sparsearray.pojo.Item;
import com.zqh.datastructures.sparsearray.pojo.Random;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author zhuangqinghui
 * @version 1.0
 * @date 2020/12/18 14:42
 */
public class SparseArray {


    private static final int row = 20000;
    private static final int count = 5000;

    public static void main(String[] args) {

        int[][] arr = new int[row][row];

        random(arr);
        long l = System.currentTimeMillis();
        //int[][] sparseArr = toSparseArr(arr);
        //printArr(sparseArr);

        List<Item> list = toSparseList(arr);
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

```

> 分别使用两个方法进行计算发现确实是循环两遍的数组耗时更多
> 但是, 如果数组的行列在100以内是数组效率更高. ==这是为什么呢??==

#### 补充 (List底层原理)

##### ArrayList

* ArrayList底层就是一个数组, 但是会根据里面的元素的长度变化长度.

1. ArrayList的构造函数有三种, 分别是无参, int, 还有一个Collection三种.
2. 如果是无参的类型, 默认是一个空的数组长度为零.
3. 如果是int类型的构成函数, 则会初始化一个长度为这个参数的数组
4. 如果是还有一个Collection会复制这个集合里面的数据到新List中, 并且长度等于这个数组长度.
5. 当我们往ArrayList里面添加元素的时候, 如果数组长度足够, 直接添加, 如果长度不够, 则ArrayList会对数组进行扩展, 大小为原来的1.5倍. 但是数组必须新建, 所以在扩展之后还得将原来的数组复制给新的数组.

#### LinkedList

* LinkedList是一个双向链表

1. LinkedList有两种构造函数, 与ArrayList来比较少的是int类型的构造函数, 因为LinkedList不需要指定长度.
2. LinkedList里面有一个内部类, 和三个属性是比较重要的. 内部类是Node类, 这个类表示链表的每一个节点, 里面存放有item我们存放的对象, next链表的下一个, prev链表的上一个.

    ```java
        private static class Node<E> {
            E item;
            Node<E> next;
            Node<E> prev;

            Node(Node<E> prev, E element, Node<E> next) {
                this.item = element;
                this.next = next;
                this.prev = prev;
            }
        }
    ```

3. 三个属性, 第一个是size, 第二个是first存放第一个节点, 第三个是last存放最后一个节点.
4. 至于添加插入的操作就和双向链表相同, 可以等学习双向链表的时候.
