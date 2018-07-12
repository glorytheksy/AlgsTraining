package jianzhiOffer;

/**
 * @ClassName BinarySearch
 * @Description 
 * @author pc
 * @Date 2018年7月12日 下午12:25:06
 * @version 1.0.0
 */
public class BinarySearch {

    public static int solution(int [] a, int num) {
        if (null == a) {
            throw new RuntimeException("input is null!");
        }
        
        int lt = 0;
        int rt = a.length - 1;
        
        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if (a[mid] == num) {
                return mid;
            }
            if (a[mid] < num) {
                lt = mid;
                continue;
            }
            if (a[mid] > num) {
                rt = mid;
                continue;
            }
        }        
        return -1;
    }
    
    public static int solution2(int [] a, int num) {
        if (null == a) {
            throw new RuntimeException("input is null!");
        }
        return binarySearch(a, 0, a.length - 1, num);
        
    }
    
    private static int binarySearch(int [] a, int lt, int rt, int num) {
        int mid = (lt + rt) / 2;
        if (a[mid] == num) {
            return mid;
        }
        if (a[mid] < num) {
            lt = mid;
            return binarySearch(a, lt, rt, num);
        }
        if (a[mid] > num) {
            rt = mid;
            return binarySearch(a, lt, rt, num);
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int a[] = {1,3,4,6,7,9,10,34,56,59};    
//        int a[] = {56};
        int pos = solution2(a, 56);
        System.out.println(pos);
        if (-1 == pos) {
            System.out.println("not found");
        } else {
            System.out.println(a[pos]);
        }
    }
}
