package leetcode.algs.topological_sort;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import data_structure.Queue;
public class TopologicalSort {

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		

		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		int[] inDegree = new int[numCourses];

		for (int[] pair : prerequisites) {
			if (null == map.get(pair[1])) {
				List<Integer> list = new LinkedList<Integer>();
				list.add(pair[0]);
				map.put(pair[1], list);
			} else {
				map.get(pair[1]).add(pair[0]);
			}
			inDegree[pair[0]] += 1;

		}
		
		Queue<Integer> que = new Queue<Integer>();
		for (int i = 0; i < inDegree.length; i++) {
			if (0 == inDegree[i]) {
				que.add(i);
			}
		}
		
		int pullCnt = 0;
		while (!que.isEmpty()) {
			int head = que.poll();
			pullCnt++;
			List<Integer> list = map.get(head);
			if (null == list) {
				continue;
			}
			for (int e : list) {
				inDegree[e] = inDegree[e] - 1;
				if (0 == inDegree[e]) {
					que.add(e);
				}
			}
		}
		
		if (pullCnt < numCourses) {
			return false;
		} else if (pullCnt == numCourses){
			return true;
		} else {
			throw new RuntimeException("error");
		}

	}

	public static void main(String[] args) {
		TopologicalSort model = new TopologicalSort();
		int[][] arr = {{1,0}};
		System.out.println(model.canFinish(2, arr));
						
	}

}
