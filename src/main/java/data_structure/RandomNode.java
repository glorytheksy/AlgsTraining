package data_structure;

/**
 * 
 * @ClassName RonNode
 * @Description 拥有随机指针的链表
 * @author 叶晓蒙
 * @Date 2017年9月7日 上午8:55:16
 * @version 1.0.0
 */
public class RandomNode {

    public int value;
    public RandomNode next;
    public RandomNode rand;
    
    public RandomNode(int value) {
        this.value = value;
    }
}
