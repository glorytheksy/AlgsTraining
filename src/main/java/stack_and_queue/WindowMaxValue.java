package stack_and_queue;

import java.util.ArrayList;
import java.util.List;

public class WindowMaxValue {
    
    
    public List<Integer> solution(List<Integer> list, int w) {
        if (null == list) {
            throw new RuntimeException();
        }
        
        if (w > list.size() || w <= 0) {            
            throw new RuntimeException();
        }
        
        if (1 == w) {
            return list;
        }
        
        List<Integer> rs = new ArrayList<Integer>();
        
        if (2 == w) {
            int maxIndex = 0;
            Integer maxValue = list.get(maxIndex);
            for (int i = 0 ; i < list.size() - w + 1; i++) {
                
                
            }                        
        }
        
        
        int begin = 0;                
        int maxIndex = maxIndex(list.subList(1, w));;
        int secondIndex = secondIndex(list.subList(1, w));                                
        rs.add(list.get(maxIndex) > list.get(begin) ? list.get(maxIndex) : list.get(begin));
        
        
        for (int i = 1; i < list.size() - w + 1; i++) {
            if (begin == maxIndex) {
                
            }
            
            
        }
    }
    
    
    public int maxIndex(List<Integer> list) {        
        if (null == list || 2 > list.size()) {            
            return -1;            
        }
                
        int maxIndex = (list.get(0) >  list.get(1) ? 0 : 1);
        Integer maxValue = (list.get(0) >  list.get(1) ? list.get(0) : list.get(1));
        int secondIndex = (maxIndex == 1 ? 0 : 1);
        int secondValue = (maxIndex == 1 ? list.get(0) : list.get(1));
        
        for (int i = 0; i < list.size(); i++) {
            if (maxValue < list.get(i)) {
                secondValue = maxValue;
                secondIndex = maxIndex;
                
                maxValue = list.get(i);
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    public int secondIndex(List<Integer> list) {
        if (null == list || 2 > list.size()) {            
            return -1;            
        }
                
        int maxIndex = (list.get(0) >  list.get(1) ? 0 : 1);
        Integer maxValue = (list.get(0) >  list.get(1) ? list.get(0) : list.get(1));
        int secondIndex = (maxIndex == 1 ? 0 : 1);
        int secondValue = (maxIndex == 1 ? list.get(0) : list.get(1));
        
        for (int i = 0; i < list.size(); i++) {
            if (maxValue < list.get(i)) {
                secondValue = maxValue;
                secondIndex = maxIndex;
                
                maxValue = list.get(i);
                maxIndex = i;
            }
        }
        return secondIndex;        
    }

}
