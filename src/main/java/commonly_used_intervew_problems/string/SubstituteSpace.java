package commonly_used_intervew_problems.string;

/**
 * @ClassName SubstituteSpace
 * @Description substitute space(" ") with "%20" in a String
 * @author 叶晓蒙
 * @Date 2018年6月8日 下午4:54:39
 * @version 1.0.0
 */
public class SubstituteSpace {
    
    public void solution(StringBuffer str) {
        /* count how  many spaces are in the str */
        int strLen = str.length(); 
        int count = 0;
        for (int i = 0; i < strLen; i++) {
            if (str.charAt(i) == ' ') {
                count += 2;
            }
        }             
        
        /* traverse the augmented str backwards, implement substitution */
        char [] augmentStr = new char[count];  
        str.append(augmentStr);
        
        int p1 = strLen - 1;
        int p2 = strLen - 1 + count;
        
        while (p1 > 0) {
            
            if (' ' != str.charAt(p1)) {
                str.setCharAt(p2, str.charAt(p1));
                p1--;
                p2--;
            } else {
                str.setCharAt(p2, '0');
                str.setCharAt(p2 - 1, '2');
                str.setCharAt(p2 - 2, '%');
                p1--;
                p2 = p2 - 3;
            }
            
        }        
        System.out.println(str);
    }
    
    public static void main(String[] args) {        
        SubstituteSpace test = new SubstituteSpace();
        test.solution(new StringBuffer("hello World "));        
    }
    
}
