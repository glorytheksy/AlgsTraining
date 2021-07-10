package utils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 算法中常见的代码
 */
public class CommonJavaCode {

    public static void main(String[] args) {
        /* int [] 转 List */
        /* 不要想着有什么特殊的方法（太繁琐，容易出问题），老老实实创建个List轮询加入吧 */
        int [] testArr = {2,3,2,3,23};
        List<Integer> list = new ArrayList<Integer>();
        for (int e: testArr) {
            list.add(e);
        }
        
        /* 排序 */
        Collections.sort(list, Collections.reverseOrder()); // 逆序的话加一个参数就好
        System.out.println(list.toString());
        
        /* String 转 char */
        String s = "sfsafasf";
        char [] strToChar = s.toCharArray();
        
        /* 数组的直接初始化 */
        int [] a = {1,2,3,4};
        // 如果不想给数组取名，直接用，可以这样
        List<int []> list1 = new ArrayList<int []>();
        list1.add(new int [] {2,3,4}); // 注意这里不要表明数组长度
        // 高维数组可以这样初始化
        int [][] grid = {{1,2,},{3,4}};
        // 高维数组的高和宽
        int height = grid.length;
        int width = grid[0].length;
        
        /* 队列的初始化 */
        // Queue是个借口，初始化的时候要用的LinkedList<>
        Queue<Integer> que = new LinkedList<Integer>();
        
    }
    
    

}
