package impl_of_Algorithms.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @ClassName DepthFirstPath
 * @Description 深度优先探索路径
 * @author 叶晓蒙
 * @Date 2017年11月25日 上午12:43:20
 * @version 1.0.0
 */
public class DepthFirstPath {
    
    private MyGraph graph;
    // 起点
    private int v;
    private boolean [] marked;
    private int count;
    // this is the tricky place!!! 到达某个点路径上的最后一个点 
    private int [] lastButTow;
            
    public DepthFirstPath(MyGraph graph, int v) {
        if (null == graph || v < 0) {
            throw new RuntimeException("error");
        }
        this.graph = graph;        
        this.marked = new boolean [graph.getV()];
        this.count = 0;
        init(graph, v);
    }
    
    private void init(MyGraph graph, int v) {
        this.v = v;
        this.lastButTow = new int [graph.getV()];
        for (int i = 0; i < this.lastButTow.length; i++) {
            this.lastButTow[i] = -1;
        }
        dfs(v);
        
    }
    
    private void dfs(int s) {
        this.marked[s] = true;
        this.count++;
        
        for (int e : this.graph.adj(s)) {
            if (false == this.marked[e]) {
                this.lastButTow[e] = s;
                dfs(e);
            }
        }
    }
    
    public boolean hasPathTo(int d) {
        return this.lastButTow[d] != -1;
    }
    
    public List<Integer> pathTo(int d) {        
        if (!this.hasPathTo(d)) {
            return null;
        }
        
        List<Integer> rslst = new ArrayList<Integer>();
        int temp = d;
        while (temp != -1) {
            rslst.add(this.lastButTow[temp]);
            temp = this.lastButTow[temp];
        }
        return rslst;
    }

}
