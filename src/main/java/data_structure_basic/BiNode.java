package data_structure_basic;

/**
 * @ClassName DEndNode
 * @Description 双向链表
 * @author yxmfi
 * @Date 2019年1月12日 上午10:07:45
 * @version 1.0.0
 */
public class BiNode {

    private int value;
    
    private BiNode post;
    
    private BiNode pre;
        
    public BiNode() {
    }
    
    public BiNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BiNode getPost() {
        return post;
    }

    public void setPost(BiNode post) {
        this.post = post;
    }

    public BiNode getPre() {
        return pre;
    }

    public void setPre(BiNode pre) {
        this.pre = pre;
    }

}
