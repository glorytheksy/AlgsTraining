package data_structure;

/**
 * @ClassName DEndNode
 * @Description 双向链表
 * @author yxmfi
 * @Date 2019年1月12日 上午10:07:45
 * @version 1.0.0
 */
public class DEndNode {

    private int value;
    
    private DEndNode post;
    
    private DEndNode pre;
        
    public DEndNode() {
    }
    
    public DEndNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public DEndNode getPost() {
        return post;
    }

    public void setPost(DEndNode post) {
        this.post = post;
    }

    public DEndNode getPre() {
        return pre;
    }

    public void setPre(DEndNode pre) {
        this.pre = pre;
    }

}
