package algorithms.sort;

import utils.CommonUtils;

/**
 * @ClassName BubbleSort
 * @Description 冒泡排序
 * @author yxmfi
 * @Date 2019年2月11日 下午11:49:16
 * @version 1.0.0
 */
public class BubbleSort {
    /*
     * 时间复杂度 O(n^2)
     * 
     */
    public int[] bubbleSort(int[] arr) {
        boolean isSortFinish = false;
        while (!isSortFinish) {
            isSortFinish = true;
            for (int pos = 0; pos < arr.length - 1; pos++) {
                if (arr[pos] > arr[pos + 1]) {
                    CommonUtils.swap(arr, pos, pos + 1);
                    isSortFinish = false;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        BubbleSort qs = new BubbleSort();
        int arr[] = new int[] {7, 1, 4, 5, 10, 6 };
        ;
        arr = qs.bubbleSort(arr);
        for (int e : arr) {
            System.out.println(e);
        }
    }
}
