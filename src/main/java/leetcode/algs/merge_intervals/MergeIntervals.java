package leetcode.algs.merge_intervals;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import utils.CommonUtils;
/**
 * 
 * @author glorythesky
 * problem 56
 * Given a collection of intervals, merge all overlapping intervals.
 */
public class MergeIntervals {

	class MyComp implements Comparator<int[]> {
		@Override
		public int compare(int[] o1, int[] o2) {
			return o1[0] - o2[0];
		}
	}

	public int[][] merge(int[][] intervals) {
		List<int[]> intervalsList = Arrays.asList(intervals);
		Collections.sort(intervalsList, new MyComp());
		
		List<int[]> rs = new LinkedList<int []>();
		
		for (int i = 0; i < intervalsList.size(); ){
			int pos = i + 1;
			if (pos >= intervalsList.size()) {
				rs.add(intervalsList.get(i));
				break;
			}
			
			int max = intervalsList.get(i)[1];
			while (intervalsList.get(i)[1] >= intervalsList.get(pos)[0]) {
				if (intervalsList.get(i)[1] <= intervalsList.get(pos)[1]) {
					max = intervalsList.get(pos)[1];
				} 
				pos++;
			}			
			rs.add(new int[] {intervalsList.get(i)[0], max});
			i = pos;
		}				
		return rs.toArray(new int[intervalsList.size()][]);
	}
	
	public static void main(String[] args) {
		int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
		MergeIntervals solution = new MergeIntervals();		
		for (int [] e : solution.merge(arr)) {
			CommonUtils.printArr(e);
			System.out.println();
		}		
	}
	
	
}
