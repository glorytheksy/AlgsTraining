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
        int [] testArr = {2,3,2,3,23,1};
        List<Integer> list = new ArrayList<Integer>();
        for (int e: testArr) {
            list.add(e);
        }
        
        /* List 转  int [] 
         * 老老实实按照定义来，不然真的太麻烦了，也不好记得住
         * */
        
        /* List排序 */
        Collections.sort(list);
        // 降序
        Collections.sort(list,  Collections.reverseOrder());
        System.out.println(list.toString());
        
        /* Array排序 */
        Arrays.sort(testArr);
        // 降序可以用  Collections.reverseOrder() 但是arr必须转Integer []

        
    }
    
    

}
