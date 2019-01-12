package algorithms.graph;

import java.util.HashSet;

/**
 * @ClassName Graph
 * @Description 无向图的实现
 * @author 叶晓蒙
 * @Date 2017年11月24日 下午4:28:28
 * @version 1.0.0
 */
public class Graph {
    
    // 顶点数目(顶点英文： vertex)
    private final int V;
    // 边数目
    private int E;
    // 每个点对应的毗邻点集合
    private HashSet<Integer> [] adj;
    
    /**
     * @Description 初始化具有v个顶点没有边的图
     * @param v
     */
    public Graph(int v) {
        if (0 >= v) {
            throw new RuntimeException();
        }
        this.V = v;
        this.E = 0;
        initAdj(v);        
    }
    
    /**
     * @Description 连通两点
     * @param v1
     * @param v2
     */
    public void addEdge(int v1, int v2) {
        if (v1 > this.V || v2 > this.V) {
            throw new RuntimeException("error");
        }
        if (this.adj[v1].contains(v2)) {
            return;
        }
        
        adj[v1].add(v2);
        adj[v2].add(v1);
        E++;
    }
    
    public Iterable<Integer> adj(int v) {
        return this.adj[v];
    }
        
    public int getV() {
        return this.V;
    }
    
    public int getE() {
        return this.E;
    }
    
    public void pirnt() {
        for (HashSet<Integer> v : adj) {
            System.out.println(v);
        }            
    }

    /**
     * @Description 初始化邻接(v个顶点每个顶点的度为0)
     * @param v
     */
    @SuppressWarnings("unchecked")
    private void initAdj(int v) {
        this.adj = new HashSet[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new HashSet<Integer>();
        }
    }
    
    public static void main(String[] args) {
        Graph g = new Graph(5);
        
        g.addEdge(0 , 2);
        g.addEdge(0 , 3);
        g.addEdge(2 , 3);
        g.addEdge(2 , 4);
        g.addEdge(1 , 2);
        
        g.pirnt();
               
    }
    
}
