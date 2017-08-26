package stack_and_queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WindowMaxValue_OptimVersion {

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
            while ( qmax.size() > 0 && list.get(qmax.getLast()) <= list.get(i)) {                    
                qmax.removeLast();
            }
            qmax.add(i);              
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
