package com.sort.client;

import java.util.Arrays;
import java.util.List;

/**
 * Created by dupeiyong on 2019/4/2.
 * <p>
 * 冒泡排序描述：
 * 重复地走访要排序的元素列，依次比较两个相邻的元素，如果
 * 他们的顺序（如从大到小、首字母从A到Z）错误就把他们交换过来。
 * 走访元素的工作是重复地进行直到没有相邻元素需要交换，也就是
 * 说该元素已经排序完成。这个算法的名字由来是因为越大的元素会
 * 经由交换慢慢“浮”到数列的顶端（升序或降序排列），就如同碳酸
 * 饮料中二氧化碳的气泡最终会上浮到顶端一样，故名“冒泡排序”。
 * <p>
 * <p>
 * 算法原理：
 * 1、比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 2、对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
 * 3、针对所有的元素重复以上的步骤，除了最后一个(因为它就是最大的)。
 * 4、持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较
 * <p>
 * 算法稳定性：
 * 冒泡排序就是把小的元素往前调或者把大的元素往后调。比较是相邻的两个
 * 元素比较，交换也发生在这两个元素之间。所以，如果两个元素相等，是不
 * 会再交换的；如果两个相等的元素没有相邻，那么即使通过前面的两两交换
 * 把两个相邻起来，这时候也不会交换，所以相同元素的前后顺序并没有改变，
 * 所以冒泡排序是一种稳定排序算法。
 * <p>
 * <p>
 * 时间复杂度：
 * <p>
 * 1、最小时间复杂度O(0)：当元素列已经是正序的时候 比较最少次数C=N-1
 * 即只需要比较N-1次的就可以完成 交换次数为0  相应的移动次数也就是0，所以
 * 最小时间复杂度0次即O(0)
 * 2、最大时间复杂度O(n²)：当元素列正好相反的时候 比较最大次数C=N*(N-1)/2
 * 即最多是N*(N-1)/2次的比较就可以完成达到正序数据 交换次数乘以每次交换的移动次数
 * 3*N(N-1)/2(3是交换一次时的最小移动数据次数) 当N趋于无穷大时
 * 基本上和n²一样接近，即f(n)=3n²/2-3*n/2 ≈ f(n)=n²+2n+2 ≈ f(n)=n²，所以
 * 最大时间复杂度O(n²)
 */
public class BubbleClass {

    static Integer arr[] = {7, 9, 8, 5, 2, 0, 1, 6, 3, 4};//杂乱不重复
    //    static int arr[] = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};//最大移动次数
//    static int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};//0次移动
    static int swapCount = 0;//统计交换次数
    static int moveCount = 0;//统计总共移动的次数
    static int temp;
    static boolean ok = true;//已经是正序元素列
    static long startTime = System.currentTimeMillis();//未排序前的时间(数据太少没意义)
    static long endTime;//排完序后的时间(数据太少没意义)

    public static void main(String[] args) {
        int len = arr.length;//需要比较的数组的长度
        int tempRoundCount = len - 1;//进行 len - 1 轮
        for (int i = 0; i < tempRoundCount; i++, ok = true) {
            int tempCompareCount = tempRoundCount - i;//每轮进行 tempRoundCount - i 次比较
            for (int j = 0; j < tempCompareCount; j++) {
                if (arr[j] > arr[j + 1]) {//关键比较次数C
                    //交换一次数据 记录移动三次
                    swapCount++;

                    temp = arr[j];//移动一次
                    arr[j] = arr[j + 1];//移动一次
                    arr[j + 1] = temp;//移动一次

                    ok = false;
                }
            }
            if (ok) {
                break;
            }
        }
        moveCount = swapCount * 3;
//        Arrays.sort(arr);
//        endTime = System.currentTimeMillis() - startTime;
//        System.out.println("endTime = " + endTime);
        System.out.println("记录移动次数 moveCount = " + moveCount);


        //最终结果展示
        Arrays.asList(arr).forEach(a -> System.out.print(a + " "));
//        for (int a : arr) {
//            System.out.print(a + " ");
//        }
//        for (int i = 0; i < len; i++) {
//            System.out.print(arr[i] + " ");
//        }

    }

}
