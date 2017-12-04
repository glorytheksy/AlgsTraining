package impl_of_Algorithms.graph;

/**
 * 
 * @ClassName DeepFirstSearch
 * @Description 深度优先搜索
 * @author 叶晓蒙 
 * @Date 2017年11月24日 下午6:14:20
 * @version 1.0.0
 */
public class DeepFirstSearch {

    private MyGraph graph;
    private boolean [] marked;
    private int count;
        
    public DeepFirstSearch(MyGraph graph) {
        if (null == graph) {
            throw new RuntimeException("error");
        }
        this.graph = graph;
        this.marked = new boolean [graph.getV()];
        this.count = 0;
    }
    
    /**
     * 
     * @Description 深度优先搜索，从s点出发
     * @param s
     */
    public void dfs(int s) {
        this.marked[s] = true;
        this.count++;
        
        for (int e : this.graph.adj(s)) {
            if (false == this.marked[e]) {
                dfs(e);
            }
        }
    }
    
    public int getCount() {
        return this.count;
    }
    
    public static void main(String[] args) {
        MyGraph g = new MyGraph(2);
        g.addEdge(0, 1);
        DeepFirstSearch search = new DeepFirstSearch(g);
        search.dfs(0);
        System.out.println(search.getCount());
    }
    
    
}
