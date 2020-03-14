package leetcode.algs.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author glorythesky
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * 
 * 
 *
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class AllPathToASum {

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> rs = new ArrayList<List<Integer>>();
		List<Integer> curRoute = new ArrayList<Integer>();
		this.traverse(root, rs, curRoute, sum);
		
		return rs;
	}

	private void traverse(TreeNode root, List<List<Integer>> rs, List<Integer> curR, int sum) {
		if (null == root) {
			return;
		}
		
		curR.add(root.val);
		if (hasNoChild(root)) {			
			if (sum == this.sum(curR)) {
				rs.add(this.deepCopy(curR));
			}
		} else {
			traverse(root.left, rs, curR, sum);
			traverse(root.right, rs, curR, sum);
		}			
		curR.remove(curR.size() - 1);
	}

	private boolean hasNoChild(TreeNode root) {
		if (null == root) {
			return true;
		}
		if (null == root.left && null == root.right) {
			return true;
		} else {
			return false;
		}
	}

	private int sum(List<Integer> list) {
		if (null == list) {
			return 0;
		}

		int sum = 0;
		for (int e : list) {
			sum += e;
		}
		return sum;
	}
	
	private List<Integer> deepCopy(List<Integer> list) {
		List<Integer> rs = new ArrayList<Integer>();
		if (null == list) {
			return rs;
		}
		for (int e : list) {
			rs.add(e);
		}
		return rs;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.left.left = new TreeNode(1);
		
		AllPathToASum obj = new AllPathToASum();
		List<List<Integer>> rs = obj.pathSum(root, 4);
		
		for (List<Integer> list : rs) {
			for (int e : list) {
				System.out.print(e + " ");
			}
			System.out.println();
		}
	}
	
}
