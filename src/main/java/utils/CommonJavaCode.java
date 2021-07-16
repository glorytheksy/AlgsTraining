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
        // java 队列的加和减，使用offer和poll
        que.offer(3);
        que.poll();
        
        /* java List 的拷贝*/
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        // 可以使用clone, 注意clone 只能使Object调用，接口是调用不了的
        ArrayList<Integer> list3 = (ArrayList<Integer>) list2.clone();
        // 也可以用新建List初始化的方法拷贝
        List<Integer> list4 = new ArrayList<Integer>(list2);
        
        /* java List的合并使用addAll */
        List<Integer> list5 = new ArrayList<Integer>();
        list5.add(5);
//        list5.addAll(null);  注意不可以addAll null
        System.out.println(list5);
        
        /* java中的/**注释该怎么去除？ */
        // 没有快捷键，就用alt + 鼠标纵向选择，再delete即可 
    }
    
    

}
