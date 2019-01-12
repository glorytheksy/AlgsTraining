package algorithms.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName EdgeWeightedDigraph
 * @Description 有向权重图
 * @author 叶晓蒙
 * @Date 2018年3月5日 下午3:14:38
 * @version 1.0.0
 */
public class WeightedDirectedGraph {
    
    private List<Edge>[] adj; // 邻接表矩阵  
    private int V; // 点的数目  
    private int E; // 边的数目  
      
    @SuppressWarnings("unchecked")
    public WeightedDirectedGraph(int V) {  
        this.V = V;  
        E = 0;  
        adj = (List<Edge>[]) new List[V];  
        for (int i = 0; i < V; i++) {  
            adj[i] = new ArrayList<>();  
        }  
    }  
      
    public void addEdge(Edge e) {  
        adj[e.getFrom()].add(e);  
        E++;  
    }  
      
    public int V() {  
        return V;  
    }  
      
    public int E() {  
        return E;  
    }  
      
    public Iterable<Edge> adj(int v) {  
        return adj[v];  
    }  
      
    public Iterable<Edge> edges() {  
        List<Edge> edges = new ArrayList<>();  
        for (int i = 0; i < V; i++) {  
            for (Edge e : adj[i]) {  
                edges.add(e);  
            }  
        }  
        return edges;  
    }  
      
    public String toString() {  
        String s = V + " 个顶点, " + E + " 条边\n";  
        for (int i = 0; i < V; i++) {  
            s += i + ": ";  
            for (Edge e : adj(i)) {  
                s += e.getTo() + " [" + e.weight() + "], ";  
            }  
            s += "\n";  
        }  
        return s;  
    }  
}
