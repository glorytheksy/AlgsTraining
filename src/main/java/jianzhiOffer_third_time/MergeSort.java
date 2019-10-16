package jianzhiOffer_third_time;

/**
 * @ClassName MergeSort
 * @Description 归并排序
 * @author yxmfi
 * @Date 2019年9月10日 下午10:09:09
 * @version 1.0.0
 */
public class MergeSort {
    
    public void solution(int [] arr) {
        if (null == arr) {
            throw new RuntimeException("error");
        }
        
        this.sort(arr, 0, arr.length - 1);
    }
    
    private void sort(int [] arr, int start, int end) {
        if (start == end) {
            return;
        } else {            
            int mid = 1 + (start + end) / 2 ;
            sort(arr, start, mid - 1);
            sort(arr, mid, end);
            merge(arr, start, mid, end);
        }        
    }
    
    public void merge(int [] arr, int start, int mid, int end) {
        // 辅助
        int [] augx = new int [end - start + 1];
        int pt1 = start;
        int pt2 = mid;
        
        int cnt = 0;
        while (pt1 <= mid - 1 || pt2 <= end) {
            if (pt1 > mid - 1) {
                augx[cnt] = arr[pt2];
                pt2++;
            } else if (pt2 > end){
                augx[cnt] = arr[pt1];
                pt1++;
            } else {
                if (arr[pt1] < arr[pt2]) {
                    augx[cnt] = arr[pt1];
                    pt1++;
                } else {
                    augx[cnt] = arr[pt2];
                    pt2++;
                }
            }            
            cnt++;            
        }
        
        for (int i = 0; i < augx.length; i++) {
            arr[start + i] = augx[i];
        }
        System.out.println();
        
    }
    
    
    public static void main(String[] args) {
        MergeSort merge = new MergeSort();
        int [] arr = new int [] {3,4,546,54,654,4,4,4,5,54,8};
        int start = 0;
        int mid = 7;
        int end = arr.length - 1;
        
//        merge.merge(arr, start, mid, end);
        merge.solution(arr);
        
        for (int ele : arr) {
            System.out.println(ele);
        }
    }

}
