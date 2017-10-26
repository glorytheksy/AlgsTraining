package impl_of_Algorithms.hash;

/**
 * 
 * @ClassName ProbingHash
 * @Description 线性探测哈希
 * @author yxmfi
 * @Date 2017年10月27日 上午12:42:09
 * @version 1.0.0
 * @param <T>
 */
public class ProbingHash<T> implements ImportantHashMethod<T>{
    private static final int DEFAULT_TABLE_SIZE = 37;
    // 散列表
    private T [] prbLst;
    // prbLst长度
    private int N;
    // 元素的个数
    private int M;
        
    public ProbingHash() {
        this.prbLst = (T [])new Object[DEFAULT_TABLE_SIZE];
        this.N = prbLst.length;
        this.M = 0;
    }
    
    public void insert(T t) {
        if ( M > N/2) {
            this.resize();
        }
        
        int hash = t.hashCode() % N;
        int i = hash;
        for (; prbLst[i] != null; i = (i + 1) % N ) {
            if (prbLst[i] == t) {
                return;
            }
        }
        prbLst[i] = t;
        
    }
    
    public boolean contains(T t) {        
        return (null != this.get(t));        
    }
    
    private T get(T t) {
        
        int hash = t.hashCode() % N;
        for (int i = hash; prbLst[i] != null; i = (i + 1) % N ) { // 为了在能让循环停止不要越界， "% N" 是必须加的
            if (prbLst[i] == t) {
                return t;
            }
        }
        return null;
    }
    
    private void resize() {        
        T [] newLst = (T [])new Object[2*M];
        for (int i = 0; i < M; i++) {
            newLst[i] = this.prbLst[i];
        }
        M = M * 2;
        prbLst = newLst;
    }
}
