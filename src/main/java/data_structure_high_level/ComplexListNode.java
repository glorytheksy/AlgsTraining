package data_structure_high_level;

/**
 * @ClassName ComplexListNode
 * @Description 复杂链表
 * @author yxmfight
 * @Date 2018年7月17日 下午12:55:04
 * @version 1.0.0
 */
public class ComplexListNode {
    
    int value;
    ComplexListNode next;
    ComplexListNode sibling;
    
    public ComplexListNode(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }

    
    public void setValue(int value) {
        this.value = value;
    }

    
    public ComplexListNode getNext() {
        return next;
    }

    
    public void setNext(ComplexListNode next) {
        this.next = next;
    }

    
    public ComplexListNode getSibling() {
        return sibling;
    }

    
    public void setSibling(ComplexListNode sibling) {
        this.sibling = sibling;
    }


}
