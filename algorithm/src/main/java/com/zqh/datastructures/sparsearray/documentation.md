# 稀疏数组

## 定义

存在一个二维数组大部分是0, 之后少部分有数值的时候我们可以采用稀疏数组存储数据, 节约空间

如:

$$\begin{matrix}
&0   &0 &  0 &  22 & 0 &  0 &  15 \\
&0  & 11 &  0 &  0  & 0  & 17 & 0\\
&0  & 0  & 0  & -6  &0  & 0  & 0\\
&0  & 0  & 0  & 0   &0  & 19 & 0\\
&91  &0  & 0  & 0   &0  & 0  & 0\\
&0  & 0  & 28 & 0   &0 &  0  & 0\\
\end{matrix}$$

我们可以存储这样一个稀疏数组表示这个二维数组
|行 |  列  | 值 | |
| :----: | :----: | :----: | :----: |
|6  |  7  |  8  |   稀疏数组第一行表示, 总的几行几列几个值 |
|0  |  3  |  22 |   第二行开始记录每一个数的位置和值 |
|0  |  6  |  15|
|1  |  1  |  11|
|1  |  5  |  17|
|2  |  3  |  -6|
|3  |  5  |  39|
|4  |  0  |  91|
|5  |  2  |  28|

这样就可以从48到24, 节省一半的空间

## 应用实例

我们以稀疏数组存放棋盘, 并且可以恢复成原来的实例.

### 二维数组转稀疏数组

1. 遍历二维数组得到原始有效个数sum
2. 创建一个稀疏数组 ==arr[ sum+1 ][ 0 ]==
3. 将有效数据存入稀疏数组.

>这边有一个疑惑如果要先遍历一遍创建数组, 那就得多遍历一遍赋值, 会多遍历一遍.
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

从代码上看确实循环了两遍, 所以我想用list再试一遍.
