package data_structure_basic;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * 
 * @ClassName Queque
 * @Description 整数队列
 * @author yxmfi
 * @Date 2017年9月4日 下午10:05:36
 * @version 1.0.0
 */
public class Queue<E> {

    protected LinkedList<E> list = new LinkedList<E>();
    
    protected int size;
    
    public boolean add(E element) {        
        boolean rs = list.add(element);
        if(rs) {
            size++;      
        }
        return rs;        
    }
    
    public boolean offer(E e) {
        return false;
    }
    
    public E remove() {
        return list.remove();
    }
    
    public E poll() {
        if (0 == size) {
            throw new NoSuchElementException();
        }
        size--;
        return list.removeFirst();        
    }
    
    public boolean isEmpty() {
        return 0 == size;
    }
    
    public E peek() {
        if (0 == size){
            throw new RuntimeException("����Ϊ0");
        }
        return list.getFirst();         
    }
    
    public E element() {
        if (0 == size){
            throw new RuntimeException("����Ϊ0");
        }
        return list.getFirst(); 
    }
    
    public int getSize() {        
        return size;        
    }
    
}
