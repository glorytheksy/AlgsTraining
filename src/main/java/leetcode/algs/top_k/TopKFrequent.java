package leetcode.algs.top_k;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
/**
 * 
 * @author glorythesky
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 * 
 * 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
 * 输入的单词均由小写字母组成。
 */
public class TopKFrequent {
	
    public List<String> topKFrequent(String[] words, int k) {
    	List<String> res = new ArrayList<String>();
    	
        Map<String, Integer> map = new HashMap<String, Integer>();
    	for (String str : words) {
    		if (map.containsKey(str)) {
    			map.put(str, map.get(str) + 1);
    		} else {
    			map.put(str, 1);
    		}
    	}
    	
    	int [] nums = new int [map.size()]; 
    	String [] dist_words = new String [map.size()];

    	int cnt = 0;
    	for (Map.Entry<String, Integer> entry : map.entrySet()) {
    		dist_words[cnt] = entry.getKey();
    		nums[cnt] = entry.getValue().intValue();
    		cnt++;
    	}
    	
    	this.sort(nums, dist_words, 0, nums.length - 1);
    	
    	for (int i = 0; i < k; i++) {
    		res.add(dist_words[i]);
    	}
    	return res;
    }
    
    public void sort(int [] nums, String dist_words[], int start, int end) {
    	if (start == end) {
    		return;
    	}
    	int pos = this.partition(nums, dist_words, start, end);
    	if (pos > start) {
    		this.sort(nums, dist_words, start, pos - 1);
    	} 
    	if (pos < end) {
    		this.sort(nums, dist_words, pos + 1, end);
    	}
    }
    
	
    public int partition(int [] nums, String dist_words[], int start, int end) {
    	if (start == end) {
    		return start;
    	}
    	int p1 = start;
    	int p2 = start + 1;
    	
    	while (p2 <= end) {
    		if (nums[p2] > nums[p1]) {
    			this.swap(nums, dist_words, p1+1, p2);
    			this.swap(nums, dist_words, p1+1, p1);
    			p1++;
    			p2++;
    		} else if (nums[p2] < nums[p1]) {
    			p2++;
    		} else {
    			if (this.isBigger(dist_words[p2], dist_words[p1])) {
        			this.swap(nums, dist_words, p1+1, p2);
        			this.swap(nums, dist_words, p1+1, p1);
    			} else {
        			this.swap(nums, dist_words, p1+1, p2);
    			}
    			p1++;
    			p2++;
    		}
    	}
    	return p1;
    }
    
    public void swap(int [] nums, String words[], int a, int b) {
    	int temp_int = nums[a];
    	String temp_wd = words[a];
    	
    	nums[a] = nums[b];
    	words[a] = words[b];
    	nums[b] = temp_int;
    	words[b] = temp_wd;
    }
    
    public boolean isBigger(String a, String b) {
    	char [] char_a = a.toCharArray();
    	char [] char_b = b.toCharArray();
    	
    	int p = 0;
    	while (p < char_a.length) {
    		if (p >= char_b.length) {
    			return false;
    		}
    		if (char_a[p] < char_b[p]) {
    			return true;
    		} else if (char_a[p] > char_b[p]) {
    			return false;
    		} 
    		p++;
    	}
    	return true;
    }
    
    public static void main(String[] args) {
    	TopKFrequent obj = new TopKFrequent();
//    	System.out.println(obj.isBigger("i", "Love"));    	
    	
    	String[] words = new String[] {"a","aa","aaa"};
    	System.out.println(obj.topKFrequent(words, 1));
    	
    	
	}
    
    
    
    
    
    
    
    
    
    
    
    

}
