package exercises;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Demo {

    public Node treeToDoublyList(Node root) {
        if (null == root) {
        	return null;
        }
        if (isLeaf(root)) {
        	return root;
        } else {
        	Node left = root.left;
        	left = this.treeToDoublyList(left);
        	Node right = root.right;
        	right = this.treeToDoublyList(right);
        	
        	Node left_right = this.getFarRight(left);
        	root.left = left_right;
        	left_right.right = root;
        	
        	right.left = root;
        	root.right = right;
        	return left;
        }
    }
    
    private Node getFarRight(Node node) {
    	if (null == node) {
    		return null;
    	}
    	Node temp = node;
    	while (temp.right != null) {
    		temp = temp.right;
    	}
    	return temp;
    }
    
    private boolean isLeaf(Node root) {
    	if (null == root) {
    		return false;
    	}
    	if (null == root.left && null == root.right) {
    		return true;
    	}
    	return false;
    }
    
    
	public static void main(String[] args) {
		Demo test = new Demo();
		Node node = new Node(4);
		node.left = new Node(2);
		node.right = new Node(5);
		node.left.left = new Node(1);
		node.left.right = new Node(3);
		
		Node rs = test.treeToDoublyList(node);
		
	}

}
