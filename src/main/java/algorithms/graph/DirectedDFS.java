package algorithms.graph;

/**
 * 
 * @ClassName DirectedDFS
 * @Description 有向图可达性
 * @author 叶晓蒙
 * @Date 2017年12月4日 下午8:32:16
 * @version 1.0.0
 */
public class DirectedDFS {

    private boolean [] marked; 
    
    
    public DirectedDFS(Digraph graph, int s) {
        dfs(graph, s);
    }
    
    
    public DirectedDFS(Digraph graph, Iterable<Integer> sources) {
        for (int e : sources) {
            dfs(graph, e);
        }
    }
    
    private void dfs(Digraph graph, int v) {
        this.marked[v] = true;
        for (int e : graph.adj(v)) {
            if (false == this.marked[e]) {
                dfs(graph, e);
            }
        }
    }
    
}
