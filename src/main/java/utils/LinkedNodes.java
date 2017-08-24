package utils;

/**
 * 
 * @ClassName LinkedNodes
 * @Description 链表
 * @author 叶晓蒙
 * @Date 2017年8月23日 下午8:02:28
 * @version 1.0.0
 * @param <T>
 */
public class LinkedNodes<T> {
    Node<T> head = null;
    
    class Node<T> {
        Node<T> next = null;// 节点的引用，指向下一个节点
        T data;// 节点的对象，即内容
        public Node(T data) {
            this.data = data;
        }
    }
    
}
