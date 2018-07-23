package jianzhiOffer;

/**
 * @ClassName Problem42
 * @Description 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 *              为简单起见，标点符号和普通字母一样处理。
 *              例如输入字符串"I am a student."， 则输出"student. a am I" 
 * 
 * @author yxmfi
 * @Date 2018年7月23日 上午10:56:03
 * @version 1.0.0
 */
public class Problem42 {
    
    /**
     * 这里注意java中从string中得到char[]的函数是toCharArray
     */    
    
    public static char [] solution(String str) {
        if (null == str) {
            throw new RuntimeException("input is null");
        }
        
        char [] chars = str.toCharArray();
        rotate(chars, 0, chars.length - 1);
        
        int start = 0;
        int end = 0;
        while (end < chars.length) {
            while (' ' != chars[end] && end < chars.length - 1) {
                end++;
            }            
            if (' ' == chars[end]) {
                rotate(chars, start, end - 1);
                start = end + 1;
                end = end + 1;
            } else {
                rotate(chars, start, end);
                return chars;
            }  
        }        
        return chars;
    }
    
    public static void rotate(char [] str, int start, int end) {
        if (null == str) {
            throw new RuntimeException("input is null");
        }        
        if (start < 0 || start > str.length - 1) {
            throw new RuntimeException("error");
        }
        if (end < 0 || end > str.length - 1) {
            throw new RuntimeException("error");
        }
        if (start > end) {
            throw new RuntimeException("error");
        }
        
        char temp = 0;
        while (end >= start) {
            temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }        
    }
    
    public static void main(String[] args) {
        String test = "abc def";
        System.out.println(solution(test));
    }

}
