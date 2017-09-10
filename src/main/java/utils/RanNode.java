package utils;

/**
 * 
 * @ClassName RonNode
 * @Description 拥有随机指针的链表
 * @author 叶晓蒙
 * @Date 2017年9月7日 上午8:55:16
 * @version 1.0.0
 */
public class RanNode {

    public int value;
    public RanNode next;
    public RanNode rand;
    
    public RanNode(int value) {
        this.value = value;
    }
}
