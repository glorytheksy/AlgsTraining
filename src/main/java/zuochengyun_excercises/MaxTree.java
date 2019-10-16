package zuochengyun_excercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import data_structure.BinaryNode;
import data_structure.StackForInt;
import data_structure.Stack;

public class MaxTree {
        
    public BinaryNode solution( ArrayList<Integer> list ) {
        BinaryNode rs = null;        
        if (null == list || list.isEmpty()){
            return null;
        }        
        if (1 == list.size()) {
            return new BinaryNode(list.get(0));
        }
        
        Map<Integer, Integer> ltBigMap = ltBigMap(list);
        Map<Integer, Integer> rtBigMap = rtBigMap(list);        
        for (int i = 0; i < list.size(); i++) {
            
            if (i == ltBigMap.get(i) && i == rtBigMap.get(i)) {
                BinaryNode left = rs;
                rs = new BinaryNode(list.get(i));
                rs.left = left;
            }            
            else {
                int headIndex;
                if (list.get(ltBigMap.get(i)) < list.get(rtBigMap.get(i))) {
                    headIndex = ltBigMap.get(i);
                } else {
                    headIndex = rtBigMap.get(i);
                }
                BinaryNode left = rs;
                rs = new BinaryNode(list.get(headIndex));
                rs.left = left;
            }            
        }
        return rs;
    }
    
    /**
     * 
     * @Description 元素左边最近的比它大的元素的下标
     * @param list
     * @return
     */
    public Map<Integer, Integer> ltBigMap(ArrayList<Integer> list) {
        Map<Integer, Integer> rs = new HashMap<Integer, Integer>(); 
        if (null == list){
            return null;
        }
        if (list.isEmpty()) {
            return rs;
        }
        
        StackForInt lt = new StackForInt();
        for (int i = 0 ; i < list.size(); i++) {            
            while (!lt.isEmpty() && list.get(lt.peek()) <= list.get(i)) {
                lt.pop();
            }
            rs.put(i, lt.isEmpty()?i:lt.peek());            
            lt.push(i);            
        }
        return rs;
    }
    
    public Map<Integer, Integer> rtBigMap(ArrayList<Integer> list) {
        Map<Integer, Integer> rs = new HashMap<Integer, Integer>(); 
        if (null == list){
            return null;
        }
        if (list.isEmpty()) {
            return rs;
        }
        
        StackForInt rt = new StackForInt();
        for (int i = list.size() - 1 ; i >= 0; i--) {            
            while (!rt.isEmpty() && list.get(rt.peek()) <= list.get(i)) {
                rt.pop();
            }
            rs.put(i, rt.isEmpty()?i:rt.peek());            
            rt.push(i);            
        }
        return rs;
        
    }
    
    
    

}
