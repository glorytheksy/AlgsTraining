package utils;
import java.util.LinkedList;

/**
 * 
 * @ClassName Queque
 * @Description 整数队列
 * @author yxmfi
 * @Date 2017年9月4日 下午10:05:36
 * @version 1.0.0
 */
public class Queque {

    protected LinkedList<Integer> list = new LinkedList<Integer>();
    
    protected int size;
    
    public void push(Integer element) {        
        list.add(element);
        size++;        
    }
    
    public Integer poll() {
        if (0 == size) {
            throw new RuntimeException();
        }
        size--;
        return list.removeFirst();        
    }
    
    public boolean isEmpty() {
        return 0 == size;
    }
    
    public Integer peek() {
        if (0 == size){
            throw new RuntimeException("����Ϊ0");
        }
        return list.getFirst();         
    }
    
    public int getSize() {        
        return size;        
    }
    
}
