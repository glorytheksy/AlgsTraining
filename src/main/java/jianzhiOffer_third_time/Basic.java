package jianzhiOffer_third_time;

import utils.CommonUtils;

public class Basic {

    /**
     * 二分查找trick : tail = mid - 1;
     */
    public void binarySearch(int[] arr, int val) {

        if (null == arr) {
            System.out.println("null param: arr");
        }

        int head = 0;
        int tail = arr.length - 1;
        int mid = (head + tail) / 2;

        if (val > arr[tail] || val < arr[head]) {
            System.out.println("val is not in arr");
        }

        while (arr[head] != arr[tail]) {
            if (arr[mid] == val) {
                System.out.println("postion: " + mid);
                return;
            }
            if (arr[mid] > val) {
                tail = mid - 1;
            } else {
                head = mid + 1;
            }
            mid = (head + tail) / 2;
        }
        System.out.println("val is not in arr");
    }

    /**
     * 归并排序trick：没什么trick，就
     */
    public void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int head, int tail) {
        if (head == tail) {
            return;
        }
        int mid = (head + tail) / 2 + 1;
        mergeSort(arr, head, mid - 1);
        mergeSort(arr, mid, tail);
        merge(arr, head, mid, tail);
    }

    private void merge(int[] arr, int head, int mid, int tail) {
        int[] temp = new int[tail - head + 1];
        int cnt = 0;

        int pt_lt = head;
        int pt_rt = mid;

        while (pt_lt <= mid - 1 || pt_rt <= tail) {
            if (pt_lt > mid - 1) {
                temp[cnt] = arr[pt_rt];
                cnt++;
                pt_rt++;
                continue;
            }

            if (pt_rt > tail) {
                temp[cnt] = arr[pt_lt];
                cnt++;
                pt_lt++;
                continue;
            }

            if (arr[pt_lt] <= arr[pt_rt]) {
                temp[cnt] = arr[pt_lt];
                cnt++;
                pt_lt++;
                continue;
            } else {
                temp[cnt] = arr[pt_rt];
                cnt++;
                pt_rt++;
                continue;
            }
        }

        for (int i = 0; i < tail - head + 1; i++) {
            arr[head + i] = temp[i];
        }
    }

    /**
     * 快排trick: 记住partition两个指针的位置就好 
     */
    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
    
    private void quickSort(int [] arr, int head, int tail) {
        if (head >= tail) {
            return;
        }
        int mid = partition(arr, head, tail);
        quickSort(arr, head, mid - 1);
        quickSort(arr, mid + 1, tail);
    }

    private int partition(int[] arr, int head, int tail) {
        int p1 = head;
        int p2 = head + 1;

        while (p2 <= tail) {
            if (arr[p2] < arr[p1]) {
                p1++;
                CommonUtils.swap(arr, p1 - 1, p2);                
                p2++;
            } else {
                p2++;
            }
        }
        return p1;
    }
    
    public void bubbleSort(int [] arr) {
        if (null == arr || 1 == arr.length ) {
            return;
        }
        int pt = 1;
        
        while (pt <= arr.length - 1) {            
            bubble(arr, pt);
            pt++;            
        }
    }
    
    private void bubble(int [] arr, int pt) {
        while (pt >= 1 && arr[pt] < arr[pt - 1]) {
            CommonUtils.swap(arr, pt, pt - 1);
            pt--;
        }
    }
    

    public static void main(String[] args) {
        Basic basic = new Basic();
        int[] arr = new int[] {6, 1, 3, 5, 7, 2, 4, 6, 8, 10, -3, -1, 999 };
        basic.bubbleSort(arr);
        CommonUtils.printArr(arr);
    }

}
