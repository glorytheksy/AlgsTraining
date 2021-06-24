package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
        Collections.sort(list);
        System.out.println(list.toString());
    }
    
    

}
