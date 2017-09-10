package utils;

import java.util.ArrayList;
import java.util.List;

public class BinaryNode {

    public int value;
    
    public BinaryNode left;
    
    public BinaryNode right;

    private int N; // 子节点数（包括自身）
    
    
    public BinaryNode() {
    }

    public BinaryNode(int value) {
        this.value = value;
    }

    public int getSize() {
        return N;
    }

    public void setSize(int n) {
        N = n;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryNode get(int value) {
        
        if (value == this.getValue()) {
            return this;
        }
        
        else if (value < this.getValue()) {
            return this.left.get(value);
        }
        
        else {
            return this.right.get(value);
        }
    }
    
    private List<BinaryNode> route = new ArrayList<BinaryNode>();
    
    /**
     * @Description 插入二叉树（假设我们不允许又重复值）
     * @param value
     * @return
     */
    public boolean put(int value) {
        
        
                
        if (value == this.value) {
            return false;
        }
        
        else if (value < this.value) {
            
            if (null == this.left) {
                this.left = new BinaryNode(value);
                this.left.setSize(1);
                return true;
            }
            else {
                boolean rs = this.left.put(value);
                if (true == rs) {
                    this.setSize(size(this.left) + size(this.right) + 1);
                }
                return rs;                
            }
        } 
        
        else {
            if (null == this.right) {
                this.right = new BinaryNode(value);
                this.right.setSize(1);
                return true;
            }
            else {
                boolean rs = this.right.put(value);
                if (true == rs) {
                    this.setSize(size(this.left) + size(this.right) + 1);
                }
                return rs;     
            }
        } 
    }

    public static int size(BinaryNode node) {
        if (node == null)
            return 0;
        else 
            return node.getSize();
    }
    
    /**
     * 
     * @Description 删除最小节点（删除最大节点同理）
     */
    public BinaryNode delMin() {
        return this.delMin_2(this);
    }
    
    /**
     * 
     * @Description 删除最小节点（返回被删除的节点值）（有缺陷，原头节点会不知去向）
     * @param root
     * @return
     */
    private int delMin(BinaryNode root) {
        if (null == root) {
            throw new RuntimeException();
        }

        if (null != root.left && null == root.left.left) {
            int rs = root.left.value;
            root.left = root.left.right;            
            root.N = size(root) - 1;
            return rs;
        }
        
        else if (null != root.left && null != root.left.left) {
            int t = delMin(root.left);
            root.N = size(root) - 1;
            return t;
        }
        
        else {
            int t = root.value;
            root = root.right;
            return t;
        }        
    }
    
    /**
     * 
     * @Description 删除最小节点(只返回头结点)
     * @param root
     * @return
     */
    private BinaryNode delMin_2(BinaryNode root) {        
        if (null == root.left) {
            return root.right;
        }
        
        else {
            root.left = delMin_2(root.left);
            root.N = size(root.left) + size(root.right) + 1;
            return root;            
        }
    }
    
    
//    private BinaryNode del(BinaryNode node) {
//        
//    }
//    
}
