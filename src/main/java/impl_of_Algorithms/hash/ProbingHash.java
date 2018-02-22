package impl_of_Algorithms.hash;

/**
 * 
 * @ClassName ProbingHash
 * @Description 线性探测哈希
 * @author 叶晓蒙
 * @Date 2017年10月27日 上午12:42:09
 * @version 1.0.0
 * @param <T>
 */
public class ProbingHash<T> {
    
    private static final int DEFAULT_TABLE_SIZE = 37;
    // 散列表
    private T [] probeList;
    // prbLst长度
    private int N;
    // 元素的个数
    private int M;
    
    /**
     * @Description 构造函数
     */
    @SuppressWarnings("unchecked")
    public ProbingHash() {
        this.probeList = (T [])new Object[DEFAULT_TABLE_SIZE];
        this.N = probeList.length;
        this.M = 0;
    }
    
    /**
     * @Description 插入
     * @param t
     */
    public void insert(T t) {
        if ( M > N/2) {
            this.resize();
        }
        
        int hash = t.hashCode() % N;
        int i = hash;
        for (; probeList[i] != null; i = (i + 1) % N ) {
            if (probeList[i] == t) {
                return;
            }
        }
        probeList[i] = t;        
    }
    
    /**
     * @Description 是否包含
     * @param t
     * @return
     */
    public boolean contains(T t) {        
        return (null != this.get(t));        
    }
    
    /**
     * @Description 获取
     * @param t
     * @return
     */
    private T get(T t) {        
        int hash = t.hashCode() % N;
        for (int i = hash; probeList[i] != null; i = (i + 1) % N ) { // 为了在能让循环停止不要越界， "% N" 是必须加的
            if (probeList[i] == t) {
                return t;
            }
        }
        return null;
    }
    
    private void resize() {        
        @SuppressWarnings("unchecked")
        T [] newLst = (T [])new Object[2*M];
        for (int i = 0; i < M; i++) {
            newLst[i] = this.probeList[i];
        }
        M = M * 2;
        probeList = newLst;
    }
}
