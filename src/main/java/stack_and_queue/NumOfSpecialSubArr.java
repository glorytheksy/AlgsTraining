package stack_and_queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @ClassName NumOfSpecialSubArr
 * @Description 最大值减去最小值小于或等于num的子数组数量
 * @author 叶晓蒙
 * @Date 2017年8月29日 上午8:36:46
 * @version 1.0.0
 */
public class NumOfSpecialSubArr {
    
    public int solution(List<Integer> list, int num) {
        int count = 0;
        
        if (null == list || list.isEmpty()) {
            throw new RuntimeException();
        }
        
        LinkedList<Integer> qmin = new LinkedList<Integer>();
        LinkedList<Integer> qmax = new LinkedList<Integer>();        
        int p1 = 0;
        int p2 = 0;
        
        qmaxPush(list, qmax, p1);
        qminPush(list, qmin, p2);
 
        while ( !(p1 == list.size() - 1 && p2 == list.size() - 1) ) {
            int sub = list.get(qmax.getFirst()) - list.get(qmin.getFirst());

            if (sub <= num && p2 < list.size() - 1) {
                p2++;
                qmaxPush(list, qmax, p2);
                qminPush(list, qmin, p2);
            }
            else {
                count = count + p2 - p1 + 1;
                if (qmax.getFirst() == p1) {
                    qmax.removeFirst();
                }
                if (qmin.getFirst() == p1) {
                    qmin.removeFirst();
                }                    
                p1++;   
            }
        }
        // 补足最后一次
        return ++count;
    }
    
    
    public void qmaxPush(List<Integer> list, LinkedList<Integer> qmax, int index) {
        
        if (null == qmax || null == list) {
            throw new RuntimeException();
        }
        
        if (index >= list.size()) {
            return;
        }
        
        while (qmax.size() != 0 && list.get(index) > list.get(qmax.getLast())) {
            qmax.removeLast();
        }
        qmax.add(index);
    }
    
    public void qminPush(List<Integer> list, LinkedList<Integer> qmin, int index) {
        
        if (null == qmin || null == list) {
            throw new RuntimeException();
        }
        
        if (index >= list.size()) {
            return;
        }
        
        while (qmin.size() != 0 && list.get(index) < list.get(qmin.getLast())) {
            qmin.removeLast();
        }
        qmin.add(index);
    }
   
    
    public static void main(String[] args) {
        NumOfSpecialSubArr nss = new NumOfSpecialSubArr();
        List<Integer> list = new ArrayList<Integer>();
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        
        System.out.println(nss.solution(list, 4));
        
    }
    
}
