package jianzhiOffer;

/**
 * @ClassName Problme38
 * @Description 统计一个数字在排序数组中出现的次数。
 *              例如输入排序数组{1,2,3,3,3,3,4,5}和数字3，由于3在数组中出现的次数是4，所以输出4。
 * @author pc
 * @Date 2018年7月18日 下午5:38:01
 * @version 1.0.0
 */
public class Problme38 {
    /**
     * 思路：二分查找，搜到之后，在向两边扩展
     */
    
    /**
     * 思路2：运用二分查找，找切分点
     */
    
    public static void main(String[] args) {
        int a [] = new int [] {1,2,3,3,3,3,4,5};
        BinarySearch.solution(a, 3);
    }
    
    
}
