package algorithms.hash;

/**
 * 
 * @ClassName ProbingHash
 * @Description 线性探测哈希
 * @author 叶晓蒙
 * @Date 2017年10月27日 上午12:42:09
 * @version 1.0.0
 * @param <T>
 */
public class ProbeHash<T> {
    
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
    public ProbeHash() {
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
        
        int pos = h(t, 0);
        for (int i = 0; null != probeList[pos]; i++, pos = h(t, i)) {
            if (t == probeList[pos]) {
                return;
            }
        }
        probeList[pos] = t;        
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
        for (int i = 0, pos = h(t, 0); null != probeList[pos]; i++, pos = h(t, i)) {
            if (t == probeList[pos]) {
                return t;
            }
        }
        return null;
    }

    /**
     * @Description 长度倍增
     */
    private void resize() {        
        @SuppressWarnings("unchecked")
        T [] newLst = (T [])new Object[2*M];
        for (int i = 0; i < M; i++) {
            newLst[i] = this.probeList[i];
        }
        M = M * 2;
        probeList = newLst;
    }
    
    /**
     * @Description 线性哈希
     * @param t
     * @param i
     * @return
     */
    private int h(T t, int i) {
        if (0 == i) {
            return this.hash(t);
        } else {
            return (this.hash(t) + i) % N;
        }
    }
    
    /**
     * @Description 基本哈希
     * @param t
     * @return
     */
    private int hash(T t) {
        return t.hashCode() % N;
    }
}
