package exercises;

public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode(int val) {
        this.val = val;
    }
    
    public boolean isLeaf(TreeNode root) {
    	if (root.left == null && root.right == null) {
    		return true;
    	} else {
    		return false;
    	}
    }

}
