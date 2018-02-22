package zcy.binary_tree;

import utils.BinaryNode;
import utils.Queue;

/**
 * 
 * @ClassName SerializeTree
 * @Description 树的序列化与反序列化
 * @author 叶晓蒙
 * @Date 2017年12月22日 下午5:11:06
 * @version 1.0.0
 */
public class SerializeTree {

    public String serializeTree(BinaryNode head) {

        if (null != head) {
            System.out.println(head);
            String treeStr = head.value + "!";
            treeStr = treeStr + serializeTree(head.left);
            treeStr = treeStr + serializeTree(head.right);
            return treeStr;
        } else {
            System.out.println("null");
            return "#!";            
        }
    }
    
    public BinaryNode unserializeTree(String tree) {
        String [] treeList = tree.split("!");
        Queue<String> treeQue = new Queue<String>();
        for (String str : treeList) {
            treeQue.add(str);
        }
        return this.unserializeTree(treeQue);
    }
    
    private BinaryNode unserializeTree(Queue<String> treeQue) {        
        if (!treeQue.peek().equals("#")) {
            BinaryNode root = new BinaryNode(Integer.parseInt(treeQue.poll()));
            root.left = unserializeTree(treeQue);
            root.right =  unserializeTree(treeQue);
            return root;
        } else {
            return null;
        }
        
    }
    
    
    public static void main(String[] args) {
        SerializeTree st = new SerializeTree();
        st.unserializeTree("1!2!23!#!");
        
    }

    
}
