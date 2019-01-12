package algorithms.graph;

public class DFS2 {
           
    public static void search(Graph g) {
        if (null == g) {
            throw new RuntimeException();
        }
        boolean [] marked = new boolean [g.getV()];
        for (int i = 0;i < g.getV();i++) {
            marked[i] = false;
        }        
        bfs(g, marked, 0);
    }
    
    private static void bfs(Graph g, boolean[] trace, int v) {
        if (true == trace[v]) {
            return;
        }
        System.out.println(v);
        trace[v] = true;
        
        for (Integer point : g.adj(v)) {
            if (true != trace[point]) {
                bfs(g, trace, point);                
            }
        }        
    }
    
    public static void main(String[] args) {        
        Graph g = new Graph(5);
        
        g.addEdge(0 , 2);
        g.addEdge(0 , 3);
        g.addEdge(2 , 3);
        g.addEdge(2 , 4);
        g.addEdge(1 , 2);
        
        search(g);        
    }
    

}
