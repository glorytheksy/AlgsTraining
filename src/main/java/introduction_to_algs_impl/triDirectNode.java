package introduction_to_algs_impl;

/**
 * 
 * @ClassName triDirectNode
 * @Description 三向节点
 * @author 叶晓蒙
 * @Date 2018年1月2日 下午12:30:23
 * @version 1.0.0
 * @param <E>
 */
public class triDirectNode<E> {
    
    E item;
    triDirectNode<E> next;
    triDirectNode<E> prev;
    triDirectNode<E> down;
    
    triDirectNode(triDirectNode<E> prev, triDirectNode<E> down, triDirectNode<E> next, E element) {
        this.item = element;
        this.next = next;
        this.prev = prev;
        this.down = down;
    }
    
    E getElement() {
      return item;  
    }
    
    triDirectNode<E> getHead() {
        triDirectNode<E> temp = this;
        while (null != temp.prev) {
            temp = temp.prev;
        }
        return temp;
    }
    
    triDirectNode<E> getTail() {
        triDirectNode<E> temp = this;
        while (null != temp.next) {
            temp = temp.next;
        }
        return temp;
    }

}
