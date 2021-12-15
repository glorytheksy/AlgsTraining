package exercises;

import utils.CommonUtils;
import utils.ListNode;

import java.util.*;

public class Test {

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> leftNums = new LinkedList<Integer>();
        for (int num : nums) {
            leftNums.add(num);
        }
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        this.backtrack(nums, res, new ArrayList<Integer>(), leftNums);
        
        return res;
        
    }
    
    public void backtrack(int [] nums, List<List<Integer>> res, List<Integer> curNums, List<Integer> leftNums) {
        if (curNums.size() == nums.length) {
            res.add(new ArrayList<>(curNums));
            return;
        }
        
        for (int i = 0; i < leftNums.size(); i++) {
            curNums.add(leftNums.remove(i));
            this.backtrack(nums, res, curNums, leftNums);
            leftNums.add(i, curNums.get(curNums.size() - 1));
            curNums.remove(curNums.size() - 1);
        }
        
    }
    
    
    
    
    public static void main(String[] args) {
        Test test = new Test();
        int [] nums = {1,2,3};

        List<List<Integer>> res = test.permute(nums);
        for (List<Integer> list : res) {
//            for (int num : list) {
//                System.out.print(num);
//            }
            System.out.print(list);
            System.out.println();
        }
    }

}
