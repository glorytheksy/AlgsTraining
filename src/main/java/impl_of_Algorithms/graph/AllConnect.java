package impl_of_Algorithms.graph;

/**
 * 
 * @ClassName AllConnect
 * @Description 求取所有连通分量的类
 * @author yxmfight
 * @Date 2017年12月3日 上午12:16:06
 * @version 1.0.0
 */
public class AllConnect {

    private boolean marked[];
    // 深度搜索的次数
    private int count;
    // 顶点属于哪一个"边"群
    private int id[];
        
    public AllConnect(Graph graph) {
        this.marked = new boolean[graph.getV()];
        this.count = 0;
        this.id = new int[graph.getV()];
        init(graph);
    }
    
    /**
     * 
     * @Description 两点是否连通
     * @param s
     * @param w
     * @return
     */
    public boolean connected(int s, int w) {
        return id[s] == id[w];
    }
    
    public int getId(int s) {
        return this.id[s];
    }
    
    /**
     * @Description 初始化连通分量
     * @param graph
     */
    private void init(Graph graph) {        
        for (int i = 0; i < graph.getV(); i++) {
            this.dfs(graph, i);
            count++;
        }                
    }
    
    /**
     * 
     * @Description dfs算法
     * @param graph
     * @param s
     */
    private void dfs(Graph graph, int s) {
        this.marked[s] = true;
        // 顺带着把所属"边"群设置一下
        this.id[s] = count;
        for (int e : graph.adj(s)) {
            if (false == this.marked[e]) {
                this.dfs(graph, e);
            }
        }
    }
}
