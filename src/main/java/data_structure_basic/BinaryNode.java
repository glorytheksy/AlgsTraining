package data_structure_basic;

/**
 * 
 * @ClassName BinaryNode
 * @Description 二叉树
 * @author yxmfi
 * @Date 2019年1月12日 上午10:08:14
 * @version 1.0.0
 */
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

    /**
     * @Description 查找节点
     * @param value
     * @return
     */
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

    /**
     * @Description 插入节点（假设我们不允许又重复值）
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
            } else {
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
            } else {
                boolean rs = this.right.put(value);
                if (true == rs) {
                    this.setSize(size(this.left) + size(this.right) + 1);
                }
                return rs;
            }
        }
    }
    

    /**
     * 
     * @Description 树的大小
     * @param node
     * @return
     */
    private int size(BinaryNode node) {
        if (node == null)
            return 0;
        else
            return node.getSize();
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
     * @Description 查找最大值，复杂度lgN
     * @return
     */
    public BinaryNode max() {
        if (null == this.right) {
            return this;
        }        
        return this.right.max();
    }
    
    /**
     * @Description 查找最小值，复杂度lgN
     * @return
     */
    public BinaryNode min() {
        if (null == this.left) {
            return this;
        }        
        return this.left.min();
    }
    
        
    /**
     * 
     * @Description 查找二叉查找树中的天花板节点
     * @param data
     * @return
     */
    public BinaryNode ceil(int data) {
        return this.ceil(this, data);
    }
            
    private BinaryNode ceil(BinaryNode root, int data) {        
        if (null == root) return null;      
        if (data == root.value) return root;
        
        else if (data < root.value) {
            if (root.left.value < data) return root; 
            else return ceil(root.left, data);
        }
        else {
            if (root.right.value > data) return root.right; 
            return ceil(root.right, data);
        }

    }
    
    /**
     * 
     * @Description 删除最小节点
     * @return
     */
    public BinaryNode delMin() {
        return this.delMin_2(this);
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
    
    /**
     * @Description 找到排名为k的元素（从大往小数）
     * @param k
     * @return
     */
    public BinaryNode select(int k) {
        return this.select(this, k);
    }
    
    private BinaryNode select(BinaryNode root, int k) {        
        if (null == root || root.N < k || 0 >= k) {
            return null;
        }
        
        int t = size(root.right);        
        if (k - 1 == t) {
            return root;
        } 
        else if (k - 1 < t) {
            return select(root.right, k);
        }
        else {
            return select(root.left, k - t - 1);
        }
    }
    
    /**
     * 
     * @Description 节点的排名（从大往小）
     * @param node
     * @return
     */
    public int rank(BinaryNode node) {
        return this.rank(this, node);
    }
    
    private int rank(BinaryNode root, BinaryNode node) {        
        if (null == node ) {
            return -1;
        }
        if (null == root) {
            throw new RuntimeException("");
        }
        
        int t = size(root);
        if (t == node.value) {
            return size(root.right) + 1;
        }
        else if (t < node.value) {
            return rank(root.right, node);
        }
        else {
            return rank(root.left, node) + 1 + size(root.right);
        }
    }
    
    /**
     * 
     * @Description 删除节点
     * @param node
     * @return
     */
    public BinaryNode del(BinaryNode node) {
        if (null == node) {
            throw new RuntimeException();
        }else {
            return this.del(this, node);
        }
    }
    
    private BinaryNode del(BinaryNode root, BinaryNode node) {
        if (null == root) return null;
        
        if (node.value == root.value) {
            if (null != root.right) {
                BinaryNode t = root.right.min();
                root.right.delMin();
                t.left = root.left;
                t.right = root.right;
                t.N = size(t.left) + size(t.right) + 1;                
            }
            else {
                return root.left;
            }
        }

        else if (node.value < root.value) {
            root.left = del(root.left, node);
        }
        else {
            root.right = del(root.right, node);
        }                
        root.N = size(root.left) + size(root.right) + 1;
        return root;  
    }

    @Override
    public String toString() {
        return this.value + "";
    }

    public static void preTraverse(BinaryNode head) {        
        if (null == head) {
            return;
        }
        System.out.println(head.value);
        preTraverse(head.left);
        preTraverse(head.right);
    }
    
    public static void midTraverse(BinaryNode head) {
        if (null == head) {
            return;
        }
        midTraverse(head.left);
        System.out.println(head.value);
        midTraverse(head.right);
    }
    
    public static void postTraverse(BinaryNode head) {
        if (null == head) {
            return;
        }
        postTraverse(head.left);
        postTraverse(head.right);
        System.out.println(head.value);
    }
    

}
