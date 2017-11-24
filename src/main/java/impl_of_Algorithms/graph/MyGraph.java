package impl_of_Algorithms.graph;

import java.util.HashSet;

import org.apache.log4j.Logger;

/**
 * 
 * @ClassName MyGraph
 * @Description 无向图的实现
 * @author 叶晓蒙
 * @Date 2017年11月24日 下午4:28:28
 * @version 1.0.0
 */
public class MyGraph {
    
    private Logger logger = Logger.getLogger(this.getClass());    

    private int V;    
    private int E;
    private HashSet<Integer> [] adj;
    
    /**
     * @Description 初始化具有v个顶点没有边的图
     * @param v
     */
    public MyGraph(int v) {
        this.V = v;
        this.E = 0;
        initAdj(v);        
    }
    
    public int getV() {
        return this.V;
    }
    
    public int getE() {
        return this.E;
    }
    
    public void addEdge(int v1, int v2) {
        if (v1 > this.V || v2 > this.V) {
            throw new RuntimeException("error");
        }
        adj[v1].add(v2);
        adj[v2].add(v1);
        E++;
    }
    
    public Iterable<Integer> adj(int v) {
        return this.adj[v];
    }

    /**
     * @Description 初始化邻接(v个顶点每个顶点的度为0)
     * @param v
     */
    private void initAdj(int v) {
        this.adj = new HashSet[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new HashSet<Integer>();
        }
    }
    
}
