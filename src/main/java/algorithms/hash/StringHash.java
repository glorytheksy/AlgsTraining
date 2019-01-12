package algorithms.hash;

/**
 * 
 * @ClassName get the hash value of String Class
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author yxmfight
 * @Date 2017年9月24日 下午10:17:12
 * @version 1.0.0
 */
public class StringHash {
    
    
    public int hashCode(String s, int carry, int M) {
        int hash = 0;
        
        for (int i = 0; i < s.length(); i++) {
            hash = (carry * hash + s.charAt(i)) % M;
        }
        
        return hash;
        
    }
    
//    public static void main(String[] args) {
//        StringHash sh = new StringHash();
//        
//        System.out.println("sdfas".charAt(0));
//        
//        System.out.println(sh.hashCode("dswehrf", 10, 97));
//    }

}
