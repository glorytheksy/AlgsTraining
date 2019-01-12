package algorithms.graph;

/**
 * 
 * @ClassName DeepFirstSearch
 * @Description 深度优先搜索
 * @author 叶晓蒙 
 * @Date 2017年11月24日 下午6:14:20
 * @version 1.0.0
 */
public class DFS {

    private Graph graph;
    private boolean [] marked;
    // 遍历了多少点
    private int count; 
        
    public DFS(Graph graph) {
        if (null == graph) {
            throw new RuntimeException("error");
        }
        this.graph = graph;
        this.marked = new boolean [graph.getV()];
        this.count = 0;
    }
    
    /**
     * @Description 由顶点s开始深度遍历所有连通着的点(由递归的方式实现)
     * @param s
     */
    public void dfs(int s) {
        this.marked[s] = true;
        this.count++;
        
        for (int e : this.graph.adj(s)) {
            if (false == this.marked[e]) {
                dfs(e);
            }
        }
    }
    
    public int getCount() {
        return this.count;
    }
    
    public static void main(String[] args) {
        Graph g = new Graph(2);
        g.addEdge(0, 1);
        DFS search = new DFS(g);
        search.dfs(0);
        System.out.println(search.getCount());
    }    
    
}
