package algorithms.graph;

import java.util.ArrayList;
import java.util.List;

import utils.Stack;

/**
 * 
 * @ClassName DirectedCycle
 * @Description 利用深度优先搜索查找有向环(简化版, 从某个点出发只找一个)
 * @author 叶晓蒙
 * @Date 2017年12月9日 下午3:47:53
 * @version 1.0.0
 */
public class DirectedCycle {

    @SuppressWarnings("unused")
    private boolean [] marked;
    @SuppressWarnings("unused")
    private List<Integer> cycle;
    private int [] lastButTwo;
    @SuppressWarnings("unused")
    
    /**
     * 只有在栈内的顶点才有可能是环内的点，该栈记录着从v到当前点的一条路径    
     * 这是一种可以快速判断点是否在栈内的方法，可以算作是利用空间换取时间的
     * 一种方式吧
     */
    private boolean [] onStack; 
    private boolean hasCycle;
    
    // TODO 这里要改成有向图类
    public DirectedCycle(Graph graph, int v) {
        this.marked = new boolean[graph.getV()];
        for (int i = 0; i < this.lastButTwo.length; i++) {
            this.lastButTwo[i] = -1;
        }
        this.onStack = new boolean[graph.getV()];
        this.cycle = new ArrayList<Integer>();
        
    }
    
    private void dfs(Graph graph, int v) {
        this.marked[v] = true;
        // 进栈
        this.onStack[v] = true;
        
        for (int e : graph.adj(v)) {
            if (this.isHasCycle()) {
                return;
            } else if (!marked[e]) {
                this.lastButTwo[e] = v;
                dfs(graph, e);
            } else if (onStack[e]) {
                this.constructCycle(v,e);
            }
        }
        
        // 出栈
        this.onStack[v] = false;        
    }
    
    private void constructCycle(int v, int e) {
        
        Stack s = new Stack(); 
        s.push(e); // 尾巴               
        int temp = v;  
        s.push(v);
        while (this.lastButTwo[temp] != e) {
            temp = this.lastButTwo[temp];
            s.push(temp);
        }
        s.push(e); // 头        
        while (!s.isEmpty()) {
            this.cycle.add(s.pop());
        }
    }
    
    
    private boolean isHasCycle() {
        return this.hasCycle;
    }
}
