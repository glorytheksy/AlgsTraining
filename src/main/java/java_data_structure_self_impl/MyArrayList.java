package java_data_structure_self_impl;

import java.util.Collection;

import com.alibaba.dubbo.common.json.JSON;

public class MyArrayList<Item> {
        
    private int curSize;
    
    private int totalSize;
    
    private final int increaseRate = 2;
    
    private final int iniLen = 20;
    
    private Item [] list;
        
    public MyArrayList() {
        /** 由于一些历史原因（详见http://www.cnblogs.com/scutwang/articles/3735219.html），
         *  java不支持泛型数组。所以不支持 list = new Item[20] 这种表达式
         */
        list = (Item[]) new Object[iniLen];
        curSize = 0;
        totalSize = iniLen;
    }
    
    /**
     * 
     * @Description 虽然赋值很麻烦，但是随着数组的增大，
     *              赋值的几率会越来越小（数组大小是指数级增长）
     * @param item
     */
    public void add(Item item) {
        if (null == item) {
            throw new RuntimeException();
        }
        
        /* 创建一个新长度的数组，赋值后抛弃原来的数组 */
        if (curSize == totalSize) {
            totalSize = increaseRate * totalSize;
            Item [] newLst = (Item []) new Object[totalSize];            
            for (int i = 0; i < curSize; i++) {
                newLst [i] = list [i];
            }            
            list = newLst;
        }    
        curSize++;
        list[curSize - 1] = item;        
    }
    
    public Item get(int index) {
        if (0 > index || curSize <= index) {
            throw new IndexOutOfBoundsException();
        }        
        return this.list[index];
    }

    public static void main(String[] args) {
        System.out.println("hw");
    }
}
