package impl_of_Algorithms.graph;

import java.util.HashSet;

/**
 * 
 * @ClassName Digraph
 * @Description 有向图自实现
 * @author 叶晓蒙
 * @Date 2017年12月4日 下午7:46:32
 * @version 1.0.0
 */
public class Digraph {

    // 顶点数目
    private final int V;
    // 边数目(这里指一条有向边)
    private int E;
    // 每个点对应的毗邻点集合(定点指向的)
    private HashSet<Integer> [] adj;
    
    /**
     * @Description 初始化具有v个顶点没有边的图
     * @param v
     */
    public Digraph(int v) {
        this.V = v;
        this.E = 0;
        initAdj(v);        
    }
    
    /**
     * 
     * @Description 连通两点(由v1指向v2)
     * @param v1
     * @param v2
     */
    public void addEdge(int v1, int v2) {
        if (v1 > this.V || v2 > this.V) {
            throw new RuntimeException("error");
        }
        adj[v1].add(v2);
        E++;
    }
    
    /**
     * 
     * @Description 获取反向图
     * @return
     */
    public Digraph reverse() {
        Digraph rs = new Digraph(this.V);
        for (int i = 0; i < this.V; i++) {
             for (int e : adj[i]) {
                 rs.addEdge(e, i);
             }
        }
        return rs;
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
}
