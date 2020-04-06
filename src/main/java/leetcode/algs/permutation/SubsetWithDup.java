package leetcode.algs.permutation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SubsetWithDup {
	
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    	nums = this.remvDup(nums);
    	List<List<Integer>> res = new ArrayList<List<Integer>>();  
    	res.add(new ArrayList<Integer>());
    	
    	for (int num : nums) {
    		res = this.subset(res, num);
    	}
    	return res;
    }
    
    private int[] remvDup(int [] nums) {
    	if (null == nums) {
    		return null;
    	}

    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for (int e : nums) {
    		map.put(e, e);
    	}
    	int [] res = new int[map.size()];
    	int cnt = 0;
    	for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
    		res[cnt] = entry.getKey();
    		cnt++;
    	}
    	return res;
    }
        
    private List<List<Integer>> subset(List<List<Integer>> lists, int num) {
    	List<List<Integer>> aug_lists = new ArrayList<List<Integer>>();
    	for (List<Integer> list : lists) {
    		List<Integer> copy = copy(list);
    		copy.add(num);
    		aug_lists.add(copy);
    	}
    	lists.addAll(aug_lists);
    	return lists;
    }
	
    private List<Integer> copy(List<Integer> list) {
    	if (null == list) {
    		return null;
    	}

    	List<Integer> res = new ArrayList<Integer>();
    	for (int e : list) {
    		res.add(e);
    	}
    	return res;
    }
	
    public static void main(String[] args) {
		
    	SubsetWithDup obj = new SubsetWithDup();
    	
    	int [] nums = new int [] {1,2,2,3};
    	
    	List<List<Integer>> lists = obj.subsetsWithDup(nums);
    	for (List<Integer> list : lists) {
    		for (int e : list) {
    			System.out.print(e + " ");
    			
    		}
    		System.out.println();
    	}
    	
    	
	}

}
