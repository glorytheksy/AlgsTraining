package algorithms.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @ClassName EdgeWeightedGraph
 * @Description 加权无向图
 * @author 叶晓蒙
 * @Date 2017年12月16日 下午8:48:00
 * @version 1.0.0
 */
public class EdgeWeightedGraph {

    private final int V;
    
    @SuppressWarnings("unused")
    private int E;
    
    private HashSet<Edge>[] adj;
    
    @SuppressWarnings("unchecked")
    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = (HashSet<Edge>[])new HashSet[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new HashSet<Edge>();
        }
    }
    
    public Iterable<Edge> Edges() {
        Set<Edge> rs = new HashSet<Edge>();
        for (int i = 0; i < V; i++) {
            for (Edge e : this.adj(i) ) {
                // 防止重复加边
                if (e.other(i) > i) {
                    rs.add(e);
                }
            }
        }
        return rs;
    }
    
    public Iterable<Edge> adj(int v) {
        return this.adj[v];
    }
    
    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        this.adj[v].add(e);
        this.adj[w].add(e);
        E++;
    }
}
