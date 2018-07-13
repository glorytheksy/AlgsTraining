package jianzhiOffer;

/**
 * @ClassName Problem8
 * @Description 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
                             输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
                             例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * @author pc
 * @Date 2018年7月12日 下午12:59:42
 * @version 1.0.0
 */
public class Problem8 {

    public static int solution(int a []) {
        if (null == a) {
            throw new RuntimeException("input is null!");
        }
        if (1 == a.length) {
            return 0;
        }
        
        int lt = 0;
        int rt = a.length - 1;
        
        while(lt <= rt) {
            int mid = (lt + rt) / 2;            
            if (lt == mid || a[mid] < a[mid -1]) {
                return mid;
            }
            
            if (a[mid] > a[rt]) {
                lt = mid;
                continue;
            }
            
            if (a[mid] <= a[rt]) {
                rt = mid;
                continue;
            }
        }        
        return -1;
    }
    
    
    public static void main(String[] args) {
      int a[] = {3,4,5};    
      int pos = solution(a);
      System.out.println(pos);
      System.out.println();
      if (-1 == pos) {
          System.out.println("not found");
      } else {
          System.out.println(a[pos]);
      }

    }
    
}
