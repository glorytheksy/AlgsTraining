package introduction_to_algs;

import utils.CommonUtils;

/**
 * 
 * @ClassName LongestCommonString
 * @Description 两个string的最大公共string的长度(动态规划的引子)
 * @author 叶晓蒙
 * @Date 2018年1月4日 下午5:17:55
 * @version 1.0.0
 */
public class LongestCommonString {

    /**
     * @Description 我们这里假设x的长度比较小
     * @param x
     * @param y
     * @return
     */
    public static int lcsLen(String x, String y) {
                
        /* 动态数组长度 */
        int xLen = x.length();
        
        int [] last = new int [xLen + 1];
        int [] cur = new int [xLen + 1];
        
        for (int i = 0; i < last.length; i++) {
            last[i] = 0;
            cur[i] = 0;
        }
        
        for (int i = 0; i < y.length(); i++) {
            String yPivot = y.substring(i, i + 1);
            for (int j = 1; j < last.length; j++) {
                if (!x.substring(j - 1,j).equals(yPivot)) {
                    cur[j] = CommonUtils.max(last[j], cur[j - 1]);
                } else {
                    cur[j] = last[j - 1] + 1;
                }
            }
            for (int k = 0; k < last.length; k++) {                
                last[k] = cur[k];
                cur[k] = 0;
            }
            
        } 
        
        return last[last.length - 1];
    }
    
    public static void main(String[] args) {
        String x = "aca";
        String y = "babca";
        int res = lcsLen(x,y);
        System.out.println(res);
    }
     
    
}
