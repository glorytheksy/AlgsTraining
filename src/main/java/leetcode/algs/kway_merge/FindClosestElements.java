package leetcode.algs.kway_merge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * @ClassName FindClosestElements
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author yxmfi
 * @Date 2020年4月16日 上午11:24:59
 * @version 1.0.0
 * 
 * 给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。
 * 返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。
 * 
 * k 的值为正数，且总是小于给定排序数组的长度。
 * 数组不为空，且长度不超过 104
 * 数组里的每个元素与 x 的绝对值不超过 104
 */
public class FindClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<Integer>();
        if (null == arr) {
            return null;
        }
        
        if (x >= arr[arr.length - 1]) {
            for (int i = arr.length - k; i <= arr.length - 1; i++) {
                res.add(arr[i]);
            }
            return res;
        }
        
        if (x <= arr[0]) {
            for (int i = 0; i <= k - 1; i++) {
                res.add(arr[i]);
            }
            return res;
        }
        
        int mid = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= x) {
                mid = i;
            }
        }        
        int p1 = mid;
        int p2 = mid + 1;
        int cnt = 0;
        PriorityQueue<Integer> que = new PriorityQueue<Integer>();
        while (p1 >= 0 || p2 <= arr.length - 1) {
            if (cnt > k - 1) {
                break;
            }
            if (p1 >= 0 && p2 <= arr.length - 1) {
                if (Math.abs(arr[p1] - x) <= Math.abs(arr[p2] - x)) {
                    que.add(arr[p1]);
                    p1--;
                } else {
                    que.add(arr[p2]);
                    p2++;
                }
                cnt++;
                continue;
            } else if (p1 < 0 && p2 <= arr.length - 1) {
                que.add(arr[p2]);
                p2++;
                cnt++;
                continue;
            } else {
                que.add(arr[p1]);
                p1--;
                cnt++;
                continue; 
            }
        }
        while (!que.isEmpty()) {
            res.add(que.poll());
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int [] arr = new int [] {0,1,2,2,2,3,6,8,8,9};
        FindClosestElements obj = new FindClosestElements();
        List<Integer> res = obj.findClosestElements(arr, 5, 9);
        System.out.println(res);
    }
    
}
