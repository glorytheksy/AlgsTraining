package introduction_to_algs;

import java.util.Queue;

import impl_of_Algorithms.graph.Edge;
import impl_of_Algorithms.graph.EdgeWeightedDigraph;

public class Dijkstra {
    
    private EdgeWeightedDigraph graph;
    
    private int s; // 源点
    
    private double [] d; // 临时距离
    
    private int [] pi; // 顶点回溯用数组
            
    public Dijkstra(EdgeWeightedDigraph graph, int s) {
        this.graph = graph;
        this.s = s;
    }
    
    
    
    /**
     * @Description 松弛操作
     * @param u 
     * @param v
     * @param w 边(u,v)的权重
     */
    private void relax(int u, int v, double w) {
        if (d[v] > d[u] + w) {
            d[v] = d[u] + w;
            pi[v] = u;
        }
    }
    
    private class VertexQueque<Integer> {
        
        
        
        
    }

    public static void main(String[] args) {
        EdgeWeightedDigraph di = new EdgeWeightedDigraph(5);
        di.addEdge(new Edge(0, 1, 3));
        di.addEdge(new Edge(0, 2, 5));
        di.addEdge(new Edge(1, 2, 2));
        di.addEdge(new Edge(1, 3, 6));
        di.addEdge(new Edge(2, 1, 1));
        di.addEdge(new Edge(2, 3, 4));
        di.addEdge(new Edge(2, 4, 6));
        di.addEdge(new Edge(3, 4, 2));
        di.addEdge(new Edge(4, 3, 7));
        di.addEdge(new Edge(4, 0, 3));
        
        System.out.println(di);
    }        
}



