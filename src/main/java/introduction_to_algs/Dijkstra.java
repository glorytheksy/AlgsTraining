package introduction_to_algs;

import algorithms.graph.Edge;
import algorithms.graph.EdgeWeightedDigraph;
/**
 * 
 * @ClassName Dijkstra 算法
 * @Description Dijkstra 算法
 * @author 叶晓蒙
 * @Date 2018年3月6日 上午9:30:35
 * @version 1.0.0
 */
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
        
        /**
         * idea:
         * 
         * 1. 集合S内存放已经
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         */
        
        
        
        
        
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



