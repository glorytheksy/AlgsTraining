package leetcode.algs.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 过程如果化为图形，很像bfs
 * @author glorythesky
 */
public class Subset {
	
    public List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();  
    	res.add(new ArrayList<Integer>());
    	
    	for (int num : nums) {
    		res = this.subset(res, num);
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
    	Subset obj = new Subset();
    	
    	int [] nums = new int [] {1,2,3,4,5};
    	
    	List<List<Integer>> lists = obj.subsets(nums);
    	for (List<Integer> list : lists) {
    		for (int e : list) {
    			System.out.print(e + " ");
    			
    		}
    		System.out.println();
    	}
	}

}
