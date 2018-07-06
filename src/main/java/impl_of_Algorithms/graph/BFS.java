package impl_of_Algorithms.graph;

import java.util.ArrayList;
import java.util.List;
import utils.Queue;

/**
 * @ClassName BFS
 * @Description 广度优先搜索算法类(既然是算法类，就应该和具体图解耦, 私有变量没必要包括MyGraph)
 * @author yxmfight
 * @Date 2017年11月28日 上午12:14:01
 * @version 1.0.0
 */
public class BFS {
    // 是否遍历过
    private boolean[] marked;
    // 到达某顶点的倒数第二个点
    private int [] lastButTwo;
    // 起点
    private int v; 
            
    public BFS(Graph graph, int v) {
        this.marked = new boolean[graph.getV()];
        this.lastButTwo = new int[graph.getV()];        
        bfs(graph);
    }
    
    public boolean hasPathTo(int d) {
        return marked[d];
    }
    
    /**
     * 
     * @Description 到达定点d的路径
     * @param d
     * @return
     */
    public List<Integer> pathTo(int d) {        
        if (!this.hasPathTo(d)) {
            return null;
        }
        
        List<Integer> rslst = new ArrayList<Integer>();
        int temp = d;
        while (temp != -1) {
            rslst.add(this.lastButTwo[temp]);
            temp = this.lastButTwo[temp];
        }
        return rslst;
    }
    
    /**
     * 
     * @Description 深度优先搜索(老的遍历过的点出来，新的进去，所以用队列)
     *              注意老的出队列的次序(很棒的算法！)
     * @param graph
     */
    private void bfs(Graph graph) {
        Queue<Integer> que = new Queue<Integer>();
        this.marked[v] = true;        
        que.add(v);        
        while(!que.isEmpty()) {
            // 老的出来
            int top = que.poll();
            for (int e : graph.adj(top)) {
                if (false == marked[e]) {
                    this.marked[e] = true;
                    this.lastButTwo[e] = top;
                    // 新的进去
                    que.add(e);
                }
            }                        
        }        
    }
    

}
