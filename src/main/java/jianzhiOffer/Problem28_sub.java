package jianzhiOffer;

import com.alibaba.dubbo.common.utils.StringUtils;

/**
 * 
 * @ClassName Problem28_sub
 * @Description 字符串组合问题
 * @author yxmfight
 * @Date 2018年7月17日 下午3:10:22
 * @version 1.0.0
 */
public class Problem28_sub {
    
    public static void solution(char [] a) {
        if (null == a) {
            throw new RuntimeException("");
        }
        
        combine("", a, 0);    
    }
    
    private static void combine(String temp, char [] a, int start) {
        if (!StringUtils.isEmpty(temp)) {
            System.out.println(temp);
        }
                          
        for (int i = start ; i < a.length ; i++) {
            combine(temp + a[i], a, i + 1);
        }
    }
        
    public static void main(String[] args) {
        char [] a = new char [] {'1','2','3', '4'};
        solution(a);
    }
        
}
