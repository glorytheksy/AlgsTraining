package exercises;

import utils.CommonUtils;
import zuochengyun_excercises.QuequeFrom2Stacks;

import java.util.*;


public class Test {
    
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if (null == root) {
            return res;
        }
        
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        ((LinkedList<TreeNode>) que).offer(root);

        List<Integer> list = new ArrayList<Integer>();
        
        int curLevelNum = 1;
        int nextLevelNum = 0;
        while (!que.isEmpty()) {
            for (int i = 1; i<=curLevelNum; i++) {
                TreeNode node = que.poll();
                list.add(node.val);
                
                if (node.left != null) {
                    nextLevelNum++;
                    que.offer(node.left);
                }
                if (node.right!= null) {
                    nextLevelNum++;
                    que.offer(node.right);
                }
            }
            curLevelNum = nextLevelNum;
            nextLevelNum = 0;
            res.add(new ArrayList<>(list));
            list = new ArrayList<>();
        }
        
        return res;
    }

    
    
    
    public static void main(String[] args) {
        Test d = new Test();

//        int[]grid = {2,3,6,7};

        TreeNode root = null;
//        
//        int target = 6;
//        System.out.println(d.twoSum(nums, ));
//        System.out.println(d.combinationSum(grid, 7));

        System.out.println(d.levelOrder(root));
        
    }
    
    
}
