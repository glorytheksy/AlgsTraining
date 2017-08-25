package stack_and_queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WindowMaxValue {
    
    
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
        
        /**
         * 构建一个双端队列 qmax。
         * 遍历数组arr时，arr元素arr[i]的index i 放入队尾，
         * 如果 arr[qmax[tail]] > arr[i], 则放入即可，不做其它动作；
         * otherwise, qmax弹出队尾, 继续比较arr[i]与qmax“当前”队尾，直到遇到这样一个队尾使得 qmax[tail] > arr[i]
         * 
         * 
         * 这样做可以保证 w 窗口向后移动的过程中，qmax始终存储着 w 窗口 前 w - 1 个元素的最大值位置信息 
         */
        
        LinkedList<Integer> qmax = new LinkedList<Integer>(); 
        for (int i = 0; i < w ; i++) {            
            if (0 == qmax.size()) {
                qmax.add(i);
            } else {                                
                while (list.get(qmax.getLast()) <= list.get(i) && qmax.size() > 0) {                    
                    qmax.removeLast();
                }
                qmax.add(i);   
            }            
        }
        
        
        return null;
    }


}
