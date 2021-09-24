package leetcode.algs.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode 870 田忌赛马
 */
public class AdvantageCount {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        if (null == nums1 || null == nums2) {
            return null;
        }
        if (nums1.length != nums2.length) {
            return null;
        }
        

        List<Integer> list1 = new ArrayList<Integer>();
        for (int e : nums1) {
            list1.add(e);
        }
        
        List<Integer> list2 = new ArrayList<Integer>();
        for (int e : nums2) {
            list2.add(e);
        }        
        
        Collections.sort(list1, Collections.reverseOrder());
        Collections.sort(list2, Collections.reverseOrder());

        for (int i = 0; i < nums1.length; i++) {
            if (list1.get(i) > list2.get(i))
                ;
            else if (list1.get(i) == list2.get(i))
                ;
            else {
                list1.add(0, list1.remove(nums1.length - 1));
            }
        }
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(list2.get(i), list1.get(i));
        }

        int [] res = new int [nums1.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = map.get(nums2[i]);
        }
        return res;
    }
    
    public static void main(String[] args) {
        int [] nums1 = {12,24,8,32};
        int [] nums2 = {13,25,32,11};
        
        AdvantageCount c = new AdvantageCount();
        int [] res = c.advantageCount(nums1, nums2);
        
        for (int e : res)
            System.out.print(e + " ");
    }
    
}
