package utils;

import java.util.Map;
import java.util.Set;
import java.util.Stack;

import data_structure_basic.Node;


/**
 * 
 * @ClassName CommonUtils
 * @Description 常用方法以及静态变量
 * @author 叶晓蒙
 * @Date 2018年1月4日 下午6:10:52
 * @version 1.0.0
 */
public class CommonUtils {
    
    /**
     * 
     * @Description 求两个整数最大值
     * @param a
     * @param b
     * @return
     */
    public static int max(int a, int b) {
        return a>b?a:b;
    }
    
    /**
     * 
     * @Description 求两个整数最小值
     * @param a
     * @param b
     * @return
     */
    public static int min(int a, int b) {
        return a<b?a:b;
    }
    
    /**
     * 
     * @Description 求两个整数求余数
     * @param x
     * @param y
     * @return
     */
    public static int mod(int x, int y) {
                
        double quotient = new Double(x).doubleValue() / new Double(y).doubleValue(); 
        return x - y * new Double(Math.floor(quotient)).intValue();
    }
    
    /**
     * 
     * @Description 整数数组元素交换
     * @param arr
     * @param p1
     * @param p2
     */
    public static void swap(int [] arr, int p1, int p2) {
        if (arr.length - 1 < p1 || arr.length - 1 < p2) {
            throw new RuntimeException("err");
        }
        
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }
    
    /**
     * 
     * @Description 打印数组
     * @param arr
     */
    public static void printArr(int [] arr) {
        if (null == arr) {
            System.out.println("null");
            return;
        }
        
        for (int ele : arr) {
            System.out.print("" + ele + " ");
        }
        System.out.println();
    }
    
    /**
     * 打印堆栈
     * @param stack
     */
    public static void printStack(Stack<Integer> stack) {
        if (null == stack) {
            System.out.println("null");
            return;
        }
        
        for (int ele : stack) {
            System.out.print("" + ele + " ");
        }
        System.out.println();
    }
    
    /**
     * 
     * @Description 打印数组的一部分
     * @param arr
     * @param head
     * @param tail
     */
    public static void printArr(int [] arr, int head, int tail) {
        if (null == arr) {
            System.out.println("null");
            return;
        }
        
        for (int i = head; i <= tail; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    /**
     * 
     * @Description 用数组构造链表
     * @param nums
     * @return
     */
    public static Node genNode(int [] nums) {
        Node res = new Node(0);
        Node head = res;
        for (int e : nums) {
            res.setNext(new Node(e));
            res = res.getNext();
        }
        return head.getNext();
    }
    
    
    public static void print2DArr(int [][] matrix) {
        for (int i = 0; i < matrix.length; i++) { //this equals to the row in our matrix.
            for (int j = 0; j < matrix[i].length; j++) { //this equals to the column in each row.
               System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); //change line on console as row comes to end in the matrix.
         }
    }
    
    public static <T> void mapAdd(Map<T, Integer> map, T t) {
        if (!map.containsKey(t)) {
            map.put(t, 1);
        } else {
            map.put(t, map.get(t) + 1);
        }
    }
    
    public static <T> void mapRemove(Map<T, Integer> map, T t) {
        if (!map.containsKey(t)) {
            return;
        } else if (1 == map.get(t)){
            map.remove(t);
        } else {
            map.put(t, map.get(t) - 1);
        }
    }
    
    public static <T> void setRemove(Set<T> set, T t) {
        if (!set.contains(t)) {
            return;
        } else {
            set.remove(t);
        }
    }
    
    public static void main(String[] args) {
        final int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
             };
        
        print2DArr(matrix);
        
        
    }
    
}
