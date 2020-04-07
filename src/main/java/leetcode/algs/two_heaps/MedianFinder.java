package leetcode.algs.two_heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
	
	Comparator<Integer> comp = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o1 - o2;
		}		
	};
	
	Comparator<Integer> compBig = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}		
	};
	
	PriorityQueue<Integer> smallQ = new PriorityQueue<Integer>(compBig);
	PriorityQueue<Integer> bigQ = new PriorityQueue<Integer>(comp);

    /** initialize your data structure here. */
    public MedianFinder() {
    	
    }
    
    public void addNum(int num) {
    	if (smallQ.size() == bigQ.size()) {
    		if (bigQ.isEmpty()) {
    			smallQ.add(num);
    			return;
    		}    		
    		if (num >= bigQ.peek()) {
    			bigQ.add(num);
    			smallQ.add(bigQ.poll());
    		} else {
    			smallQ.add(num);
    		}
    	} else if (smallQ.size() > bigQ.size()) {
    		if (num >= smallQ.peek()) {
    			bigQ.add(num);
    		} else {
    			smallQ.add(num);
    			bigQ.add(smallQ.poll());
    		}
    	} else {
    		throw new RuntimeException("err");
    	}
    }
    
    public double findMedian() {
    	if (this.smallQ.size() == this.bigQ.size() && this.smallQ.isEmpty()) {
    		return 0;
    	}
    	    	
    	if (this.smallQ.size() == this.bigQ.size()) {
    		System.out.println(this.smallQ.peek());
    		System.out.println(this.bigQ.peek());
    		return (this.smallQ.peek() + this.bigQ.peek())/2.0;
    	} else if (this.smallQ.size() > this.bigQ.size()) {
    		System.out.println(this.smallQ.peek());
    		System.out.println(this.bigQ.peek());
    		return (this.smallQ.peek());
    	} else {
    		throw new RuntimeException("err");
    	}
    }
	
	public static void main(String[] args) {
		MedianFinder obj = new MedianFinder();
		int [] arr = new int [] {3,2,1,5};
		for (int e : arr) {
			obj.addNum(e);
		}
		System.out.println(obj.findMedian());
		
	}
	
}
