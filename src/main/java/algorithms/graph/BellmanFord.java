package algorithms.graph;
/**
 * 
 * @ClassName BellmanFord
 * @Description 贝尔曼福德算法（求最短路径）
 *              本实现过程类似于dfs
 *              复杂度O(VE)
 * @author yxmfight
 * @Date 2019年1月14日 上午9:49:14
 * @version 1.0.0
 */
public class BellmanFord {
    
    private double[] vertexValues;
    
    private int[] route;

    public void calculate(WeightedGraph g, int sourcePoint) {
        if (null == g) {
            throw new RuntimeException();
        }
        
        vertexValues = new double[g.getV()];
        route = new int[g.getV()];
        for (int i = 0;i < g.getV();i++) {
            vertexValues[i] = Integer.MAX_VALUE;
        }
        vertexValues[sourcePoint] = 0;
        searchAndUpdate(g, sourcePoint);
    }
    
    public double[] getVertexValues() {
        return vertexValues;
    }
    
    public int[] getRoute() {
        return route;
    }
    
    private void searchAndUpdate(WeightedGraph g, int curPoint) {
        for (Edge edge : g.adj(curPoint)) {     
            int to = edge.getOtherPoint(curPoint);                        
            if (vertexValues[curPoint] + edge.weight() <  
                    vertexValues[to]) {
                vertexValues[to] = vertexValues[curPoint] + edge.weight(); 
                this.route[to] = curPoint;
                searchAndUpdate(g, to);
            }            
        }
    }
    
    public static void main(String[] args) {
        WeightedGraph g = new WeightedGraph(7);
        
        g.addEdge(new Edge(0, 1, 2));
        g.addEdge(new Edge(0, 2, 9));
        g.addEdge(new Edge(1, 2, 6));
        g.addEdge(new Edge(1, 3, 2));
        g.addEdge(new Edge(3, 2, 3));
        g.addEdge(new Edge(5, 2, 1));
        g.addEdge(new Edge(1, 4, 9));
        g.addEdge(new Edge(4, 5, 3));        
        g.addEdge(new Edge(3, 5, 5));
        g.addEdge(new Edge(4, 3, 6));
        g.addEdge(new Edge(4, 6, 4));
        g.addEdge(new Edge(5, 6, 7));         
        
        BellmanFord b = new BellmanFord();
        b.calculate(g, 0);
        
        int[] route = b.getRoute();
        double[] values = b.getVertexValues();
        
        for (int i = 0;i < route.length;i++) {
            System.out.print(route[i] + " ");
        }
        
        System.out.println();
        
        for (int i = 0;i < values.length;i++) {
            System.out.print(values[i] + " ");
        }
        
    }
    
    
}
