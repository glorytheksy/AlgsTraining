package impl_of_Algorithms.hash;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @ClassName ZipHash
 * @Description 基于拉链法的哈希表
 *              这一章sedgewick讲的有点失水准了，所以主要以weiss的书为准 
 * @author yxmfight
 * @Date 2017年9月30日 下午3:29:57
 * @version 1.0.0
 */
public class ZipHash<T> {
    
    private static final int DEFAULT_TABLE_SIZE = 37;
    
    private ArrayList<List<T>>  zipLst;

    public ZipHash(){
        for (int i = 0; i < DEFAULT_TABLE_SIZE; i++) {
            zipLst.add(new ArrayList<T>());
        }
    }
    
    /**
     * 插入元素时候从在链表头结点插入（因为新插的节点最有可能被查找）
     * 
     * @Description 插入元素
     * @param t
     */
    public void insert(T t) {        
        int pos = this.h(t);
        
        if (zipLst.get(pos).isEmpty()) {
            zipLst.get(pos).add(t);
        } else {            
            List<T> origin = zipLst.get(pos);
            List<T> transformed  = new ArrayList<T>();
            transformed.add(t);
            transformed.addAll(1, origin);            
            zipLst.set(pos, transformed);
        }        
    }
    
    /**
     * 算法，遍历链表数组即可
     */
    public boolean contains(T t) {
        return false;
    }
    
    /**
     * @Description 哈希方法
     * @param t
     * @return
     */
    private int h(T t) {
        int hashValue = t.hashCode();        
        hashValue = hashValue % DEFAULT_TABLE_SIZE;
        
        if (hashValue < 0) {
           hashValue = hashValue + DEFAULT_TABLE_SIZE;
        }        
        return hashValue;
    }
        
}
