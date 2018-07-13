package jianzhiOffer;

/**
 * @ClassName MergeSort
 * @Description 
 * @author pc
 * @Date 2018年7月12日 上午9:32:30
 * @version 1.0.0
 */
public class MergeSort {
    
    public static void solution(int a[]) {
        if (null == a) {
            throw new RuntimeException("input is null");
        }
        mergeSort(a, 0, a.length - 1);        
    }
    
    public static void merge(int a[], int lt, int mid, int rt) {
        int [] temp = new int[rt - lt + 1];
        int p1 = lt;
        int p2 = mid;
        int p3 = 0;
        
        while(p1 < mid || p2 < rt + 1) {
            if (p1 < mid && p2 < rt + 1) {
                if (a[p1] < a[p2]) {
                    temp[p3] = a[p1];
                    p1++;
                    p3++;
                } else {
                    temp[p3] = a[p2];
                    p2++;
                    p3++;
                }
            } else if (p1 < mid && p2 == rt + 1) {
                temp[p3] = a[p1];
                p1++;
                p3++;
            } else  {
                temp[p3] = a[p2];
                p2++;
                p3++;
            }
        }
        
        for (int i = 0; i < temp.length; i++) {
            a[lt + i] = temp[i];
        }
    }
    
    private static void mergeSort(int a[], int lt, int rt) {
        if (lt == rt) {
            return;
        }
        int mid = (lt + rt)/2;
        mergeSort(a, lt, mid);
        mergeSort(a, mid + 1, rt);
        merge(a, lt, mid + 1, rt);
    }
    
    public static void main(String[] args) {
        int a[] = {3,4,546,54,654,4,4,4,5,54,8};
        solution(a);      
        for (int e : a) {
            System.out.println(e);
        }

    }
}
