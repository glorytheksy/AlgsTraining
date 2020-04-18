package leetcode.algs.top_k;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TopKFreqNum {
    
    
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<Integer>();
        if (null == nums) {
            return null;
        }

        /**
         * build hashmap of num to freq
         */
        Map<Integer, Integer> numToFreq = new HashMap<Integer ,Integer>();                
        for (int e : nums) {
            if (null == numToFreq.get(e)) {
                numToFreq.put(e, 1);
                continue;
            }            
            numToFreq.put(e, numToFreq.get(e) + 1);
        }
        
        /**
         * build tow arrays: uniqNums and freqs
         */
        int [] uniqNums = new int[numToFreq.size()];
        int [] freqs = new int [numToFreq.size()];
        int cnt = 0;
        for (Entry<Integer, Integer> entry : numToFreq.entrySet()) {
            uniqNums[cnt] = entry.getKey();
            freqs[cnt] = entry.getValue();
            cnt++;
        }
                
        /**
         * topK freqs
         */
        this.findTopK(freqs, uniqNums, k);
        for (int i = 0; i < k; i++) {
            res.add(uniqNums[i]);
        }
        return res;
    }
    
    public void findTopK(int [] arr, int [] attachArr, int K) {
        if (K > arr.length) {
            throw new RuntimeException("err");
        }
        
        int start = 0;
        int end = arr.length - 1;
        
        int pos = this.partition(arr, attachArr, start, end);
        while(true) {            
            if (K - 1 == pos) {
                return;
            } else if (K - 1 < pos) {
                end = pos - 1;
            } else {
                start = pos + 1;
            }            
            pos = this.partition(arr, attachArr, start, end);
        }        
    }
    
    public int partition(int [] arr, int [] attachArr, int start, int end) {
        if (start == end) {
            return start;
        }
        int p1 = start;
        int p2 = start + 1;
        while (p2 < end + 1) {
            if (arr[p2] > arr[p1]) {
                utils.CommonUtils.swap(arr, p1 + 1, p2);
                utils.CommonUtils.swap(attachArr, p1 + 1, p2);
                utils.CommonUtils.swap(arr, p1 + 1, p1);
                utils.CommonUtils.swap(attachArr, p1 + 1, p1);
                p1++;
                p2++;
            } else {
                p2++;
            }            
        }
        return p1;
    }
    
    public static void main(String[] args) {
      TopKFreqNum qs = new TopKFreqNum();        
      int arr[] = new int [] {1};
//      int attachArr[] = new int [] {1,2,3,4,5,6};
      
//      System.out.println(qs.partition(arr, attachArr, 0, 5));
//      System.out.println();
//      for (int e :arr) {
//          System.out.println(e);
//      }
      
      List<Integer> res = qs.topKFrequent(arr, 1);
      for (int e :res) {
          System.out.println(e);
      }
    
    }
}