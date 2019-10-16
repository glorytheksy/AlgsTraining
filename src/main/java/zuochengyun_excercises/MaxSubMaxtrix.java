package zuochengyun_excercises;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data_structure.StackForInt;
import data_structure.Stack;

/**
 * 
 * @ClassName MaxSubMaxtrix
 * @Description 求最大子矩阵的大小
 * @author 叶晓蒙
 * @Date 2017年8月26日 下午10:22:12
 * @version 1.0.0
 */
public class MaxSubMaxtrix {
    
    /**
     * 矩阵只是每个 底的组合，所以在这里再写solution的代码并没有意义
     */
    public int solution() {        
        return -1;
    }
    
    /**
     * @Description 获取以某行作为底，面积最大的子矩阵面积
     * @param list 以某行作为底，每个元素向上连续向上有多少 1
     * @return
     */
    public int maxSubArr(List<Integer> list) {
        int maxSpan = 0;
                
        Map<Integer, Integer> ltMinIndex = ltMinIndex(list);
        Map<Integer, Integer> rtMinIndex = rtMinIndex(list);        
        for (int i = 0 ; i < list.size() ; i++) {                        
            int height = list.get(i);
            int width = rtMinIndex.get(i) - ltMinIndex.get(i) - 1;
            maxSpan = (maxSpan < height * width) ? height * width : maxSpan;
        }        
        return maxSpan;
    }
    
    
    /**
     * 
     * @Description 元素左边最近的比它小的元素的下标
     * @param list
     * @return
     */
    public Map<Integer, Integer> ltMinIndex(List<Integer> list) {
        Map<Integer, Integer> rs = new HashMap<Integer, Integer>(); 
        if (null == list){
            return null;
        }
        if (list.isEmpty()) {
            return rs;
        }
        
        StackForInt lt = new StackForInt();
        for (int i = 0 ; i < list.size(); i++) {            
            while (!lt.isEmpty() && list.get(lt.peek()) > list.get(i)) {
                lt.pop();
            }
            // 这里写 0 - 1 是为了计算方便
            rs.put(i, lt.isEmpty()? (0 - 1):lt.peek());            
            lt.push(i);            
        }
        return rs;
    }
    
    /**
     * 
     * @Description 元素右边最近的比它小的元素的下标
     * @param list
     * @return
     */
    public Map<Integer, Integer> rtMinIndex(List<Integer> list) {
        Map<Integer, Integer> rs = new HashMap<Integer, Integer>(); 
        if (null == list){
            return null;
        }
        if (list.isEmpty()) {
            return rs;
        }
        
        StackForInt rt = new StackForInt();
        for (int i = list.size() - 1 ; i >= 0; i--) {            
            while (!rt.isEmpty() && list.get(rt.peek()) > list.get(i)) {
                rt.pop();
            }
            // 这里写 list.size()  是为了计算方便
            rs.put(i, rt.isEmpty()?(list.size()):rt.peek());            
            rt.push(i);            
        }
        return rs;        
    }
}
