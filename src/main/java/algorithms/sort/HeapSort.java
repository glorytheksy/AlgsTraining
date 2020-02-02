package algorithms.sort;

import data_structure.Heap;

/**
 * 
 * @ClassName HeapSort
 * @Description 堆排序
 * @author 叶晓蒙
 * @Date 2018年2月6日 上午9:17:58
 * @version 1.0.0
 */
public class HeapSort {

    public int [] heapSort(int [] a) {
        
        Heap heap = new Heap();
        for (int e : a) {
            heap.push(e);
        }
        int [] res = new int [a.length];        
        for (int i = 0; i < a.length; i++) {
            res[i] = heap.poll();
        }
        return res;
    }
    
    public static void main(String[] args) {
        HeapSort qs = new HeapSort();        
        int arr[] = new int [] {7,1,4,5,10,6};        
        System.out.println();
        int [] a = qs.heapSort(arr);
        for (int e :a) {
            System.out.println(e);
        }
    }
}
