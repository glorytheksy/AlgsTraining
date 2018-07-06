package impl_of_Algorithms.graph;

/**
 * 
 * @ClassName MyGraphSearch
 * @Description 无向图定点搜索类(专门用于某个无向图的某个点的查询)
 * @author 叶晓蒙
 * @Date 2017年11月24日 下午5:27:20
 * @version 1.0.0
 */
public class MyGraphSearch {

    private Graph graph;
    
    private int v;
    
    public MyGraphSearch(Graph graph, int v) {
        if (null == graph || v < 0) {
            throw new RuntimeException("error");
        }
        this.graph = graph;
        this.v = v;
    }
    
    /**
     * @Description v和s是否联通 
     * @param s
     * @return
     */
    public boolean marked(int s) {
        Iterable<Integer> adjIter = this.graph.adj(v);
        for (int e : adjIter) {
            if (e == s) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * @Description v的度
     * @return
     */
    @SuppressWarnings("unused")
    public int count() {
        Iterable<Integer> adjIter = this.graph.adj(v);
        int count = 0;
        for (int e : adjIter) {
            count++;
        }
        return count;
    }
    
    
}
