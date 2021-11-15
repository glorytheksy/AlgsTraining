package exercises;

import utils.CommonUtils;
import utils.ListNode;

import java.util.*;

public class Test {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        int preVal = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == preVal) {
                continue;
            }
            if (nums[i] > 0) {
                continue;
            }

            List<List<Integer>> twoSumRes = this.twoSum(nums, i + 1, -nums[i]);
            if (!twoSumRes.isEmpty()) {
                for (List<Integer> list : twoSumRes) {
                    list.add(nums[i]);
                }
                res.addAll(twoSumRes);
            }

            preVal = nums[i];
        }
        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, int start_pos, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        int lt = start_pos;
        int rt = nums.length - 1;

        if (lt > nums.length) {
            return res;
        }

        while (lt < rt) {
            if (nums[lt] + nums[rt] < sum) {
                do {
                    lt++;
                } while (lt < nums.length - 1 && nums[lt] == nums[lt - 1]);
            } else if (nums[lt] + nums[rt] > sum) {
                do {
                    rt--;
                } while (rt > 0 && nums[rt + 1] == nums[rt]);

            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(nums[lt]);
                list.add(nums[rt]);
                res.add(list);

                do {
                    lt++;
                } while (lt < nums.length - 1 && nums[lt] == nums[lt - 1]);
            }
        }
        return res;
    }
    
    
    public static void main(String[] args) {
//        Test test = new Test();
//        int [] arr = {-1,0,1,2,-1,-4};
//        
//        List<List<Integer>> list = test.threeSum(arr);
//        CommonUtils.printArr(arr);
//        for (List<Integer> l : list) {
//            for (int e : l) {
//                System.out.print(e + " ");
//            }
//            System.out.println();
//        }
        
        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };


        PriorityQueue<Integer> q = new PriorityQueue<>(5, comp);
        
        int [] arr = {1,2,54356,456,546,74,567,90};
        for (int e : arr) {
            q.add(e);
        }
        
        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
    }

}
