package data_structure;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName KD_Tree
 * @Description N维数据点 KD树
 * @author yxmfight
 * @Date 2019年1月26日 下午6:06:21
 * @version 1.0.0
 */
public class KDNode {

    /**
     * 1. KD树是基于二叉树结构的，不同的是（1）需要记录需要划分的维度 （2）具有可回溯能力
     * 
     * 2. 完成KNN搜索，需要（1）构建基于数据的KD树 （2）源点加入KD树找出最接近点
     * 
     * 3. 计算最接近点，需要定义距离
     */
    
    private int[] value;
    
    private KDNode father;
    
    private KDNode left;
    
    private KDNode right;
    
    // 在第几维划分
    private int dim;
        
    /**
     * @Description 加入一系列点
     * @param ptList
     */
    public void add(Iterable<int[]> ptList) {
        if (null == ptList) {
            return;
        }
        for (int [] pt : ptList) {
            this.add(pt);
            if (null == this.left) {
                System.out.println("stop");
            }
        }        
    }
    
    /**
     * @Description 加入单个点
     * @param pt
     */
    public void add(int [] pt) {
        if (null == this.value) {
            this.value = pt;
            this.dim = 0;
            return;
        }
        
        if (pt[this.dim] <= this.value[this.dim]) {
            if (null == this.left) {
                KDNode left = new KDNode();
                left.setValue(pt);
                left.setFather(this);
                left.setDim((this.dim + 1) % this.value.length);
                this.setLeft(left);
            } else {
                this.left.add(pt);
            }
        } else {
            if (null == this.right) {
                KDNode right = new KDNode();
                right.setValue(pt);
                right.setFather(this);
                right.setDim((this.dim + 1) % this.value.length);
                this.setRight(right);
            } else {
                this.right.add(pt);
            }
        }        
    }
    
    

    /// KD树搜索实现目前没有想到很好的方法
//    /**
//     * 在以root为根的树上查询距离pt最近的点
//     * 
//     * 1 找到pt所在的块区域，设置初始distance（pt与父节点的距离）与初始最近点
//     * 
//     * 2 pt到当前最近点代表的分割线的距离。 (1) 若小于distance，搜索当前最近点的另外一颗子树。转(2)
//     *                                    (2) 若等于distance, 搜索当前最近点的父节点。若当前最近点没有父节点，当前最近点为总最近点。
//     *                                    
//     *                                
//     */
//    public KDNode searchClosest(KDNode root, int [] pt) {
//
//                
//    }
//    
//    private KDNode searchClosest(KDNode root, int[] pt, Distance curNearestDist) {
//        KDNode curNearestNode = this.findCloseLeaf(root, pt);
//        if (distance(pt, curNearestNode.value) < curNearestDist.distance) {
//            curNearestDist.distance = distance(pt, curNearestNode.value);
//        } else {
//            
//        }
//    }
    
    public KDNode findCloseLeaf(KDNode root, int [] pt) {
        if (null == root) {
            return null;
        }        
        if (null == root.left && pt[root.dim] <= root.value[root.dim]) {
            return root;
        } else if (null != root.left && pt[root.dim] <= root.value[root.dim]) {
            return findCloseLeaf(root.left, pt);
        } else if (null == root.right && pt[root.dim] > root.value[root.dim]) {
            return root;
        } else {
            return findCloseLeaf(root.right, pt);
        }
    }
    
    
    public static double distance(int [] pt1, int [] pt2) {
        double res = 0;
        for (int i = 0; i < pt1.length; i++) {
            res += pt1[i] * pt1[i] + pt2[i] * pt2[i];
            res = Math.sqrt(res);
        }
        return res;        
    }
    
    public static KDNode getOtherSubTree(KDNode root, int [] pt) {
        int dim = root.getDim();
        if (pt[dim] <= root.getValue()[dim]) {
            return root.getRight();
        } else {
            return root.getLeft();
        }
    }
    
    public void print() {        
        printPt(this.value);
        if (null != this.left) {
            this.left.print();
        }
        if (null != this.right) {
            this.right.print();
        }        
    }
    
    private void printPt(int [] pt) {
        if (null == pt || 0 == pt.length) {
            return;
        }
        
        System.out.print("(");
        for (int i = 0; i < pt.length - 1; i++) {
            System.out.print(pt[i] + ", ");
        }
        System.out.print(pt[pt.length - 1] + ")");
        System.out.println();
    }
            
    public int[] getValue() {
        return value;
    }
    
    public void setValue(int[] value) {
        this.value = value;
    }
    
    public KDNode getFather() {
        return father;
    }
    
    public void setFather(KDNode father) {
        this.father = father;
    }
    
    public KDNode getLeft() {
        return left;
    }
    
    public void setLeft(KDNode left) {
        this.left = left;
    }
    
    public KDNode getRight() {
        return right;
    }
    
    public void setRight(KDNode right) {
        this.right = right;
    }
    
    public int getDim() {
        return dim;
    }
   
    public void setDim(int dim) {
        this.dim = dim;
    }
    
    
    class Distance {
        double distance;        
    }
                
    public static void main(String[] args) {
        List<int []> list = new ArrayList<int []>();
        list.add(new int[] {2, 3});
        list.add(new int[] {5, 4});
        list.add(new int[] {4, 7});
        list.add(new int[] {9, 6});
        list.add(new int[] {8, 1});
        
        KDNode node = new KDNode();
        node.add(list);
        
        int[] test = node.findCloseLeaf(node, new int[] {9,1}).value;        
        for (int e : test) {
            System.out.print(e);
            
        }
    }
}
