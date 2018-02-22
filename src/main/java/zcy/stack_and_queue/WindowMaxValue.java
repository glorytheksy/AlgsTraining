package zcy.stack_and_queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WindowMaxValue {
    
    
    
    /**
     * 构建一个双端队列 qmax。
     * 遍历数组arr时，arr元素arr[i]的index i 放入队尾，
     * 如果 arr[qmax[tail]] > arr[i], 则放入即可，不做其它动作；
     * otherwise, qmax弹出队尾, 继续比较arr[i]与qmax“当前”队尾，直到遇到这样一个队尾使得 qmax[tail] > arr[i]
     * 这样做可以保证 w 窗口向后移动的过程中，qmax始终存储着 w 窗口 后 w - 1 个元素的最大值位置信息 
     */
    public List<Integer> solution(List<Integer> list, int w) {
        List<Integer> rs = new ArrayList<Integer>();

        if (null == list) {
            throw new RuntimeException();
        }

        if (w > list.size() || w <= 0) {
            throw new RuntimeException();
        }

        if (1 == w) {
            return list;
        }
        
        LinkedList<Integer> qmax = new LinkedList<Integer>(); 
        for (int i = 0; i < w ; i++) {            
            if (0 == qmax.size()) {
                qmax.add(i);
            } else {                                
                while ( qmax.size() > 0 && list.get(qmax.getLast()) <= list.get(i)) {                    
                    qmax.removeLast();
                }
                qmax.add(i);   
            }            
        }
        rs.add(list.get(qmax.getFirst()));
        
        for (int i = w ; i < list.size(); i++ ) {
            if ( (w - 1)  < (i - qmax.getFirst()) ) {
                qmax.removeFirst();                
            }
            while ( qmax.size() > 0 && list.get(qmax.getLast()) <= list.get(i) ) {                    
                qmax.removeLast();
            }
            qmax.add(i);               
            rs.add(list.get(qmax.getFirst()));
        }                
        return rs;
    }


}
