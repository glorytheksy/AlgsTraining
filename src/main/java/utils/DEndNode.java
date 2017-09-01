package utils;


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
