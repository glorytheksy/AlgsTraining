package jianzhiOffer;

/**
 * @ClassName Problem40
 * @Description 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * @author pc
 * @Date 2018年7月19日 下午12:53:19
 * @version 1.0.0
 */
public class Problem40 {
    
    /**
     * 直观算法，先排序，再遍历
     */
    
    /**
     * 好的算法(要对异或法则熟悉)
     * 
     * a xor b = b xor a
     * (a xor b) xor c = a xor (b xor c)
     * a xor a = 0
     * if a != b then a xor b = 0
     * a xor 0 = a
     */
                    
    
    private static int findOnlyUni(int [] a) {
        int temp = 0;
        for (int e : a) {
            temp = temp ^ e;
        }
        return temp;        
    }
    
    
    public static void main(String[] args) {        
        int [] a = new int [] {4,4,5,5,3};
        System.out.println(findOnlyUni(a));

    }
    

}
