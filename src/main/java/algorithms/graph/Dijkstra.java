package algorithms.graph;

import java.util.HashSet;

import algorithms.sort.ModifyPQ;

/**
 * @ClassName Dijkstra
 * @Description
 * @author yxmfi
 * @Date 2019年1月14日 下午2:49:33
 * @version 1.0.0
 */
public class Dijkstra {

    private Vertex[] vertices;

    private int[] route;

    private HashSet<Integer> vertexSet;

    private ModifyPQ<Vertex> vertexQ;

    public void calculate(WeightedGraph g, int sourcePoint) {
        init(g, sourcePoint);
        cal(g);        
    }
    
    public Vertex[] getVertices() {
        return vertices;
    }
    
    public int[] getRoute() {
        return route;
    }

    private void cal(WeightedGraph g) {
        while (!this.vertexQ.isEmpty()) {                        
            Vertex u = vertexQ.poll();
            vertexSet.add(u.getVertexNum());
            
            if (2 == u.getVertexNum()) {
                System.out.println("eee");
            }
            
            for (Edge edge : g.adj(u.getVertexNum())) {
                relax(edge); 
            }
        }
    }
    
    private void relax(Edge edge) {
        if (2 == edge.getFrom() && 4 == edge.getTo()) {
            System.out.println("stop");
        }
        if (vertices[edge.getFrom()].getValue() + edge.weight() <
                vertices[edge.getTo()].getValue()) {
            vertices[edge.getTo()].setValue(vertices[edge.getFrom()].getValue() + edge.weight());
            route[edge.getTo()] = edge.getFrom();
        }
    }

    private void init(WeightedGraph g, int sourcePoint) {
        this.route = new int[g.getV()];
        this.vertices = new Vertex[g.getV()];
        this.vertexQ = new ModifyPQ<Vertex>();
        this.vertexSet = new HashSet<Integer>();
        
        for (int i = 0; i < g.getV(); i++) {
            if (sourcePoint == i) {
                Vertex v = new Vertex(i, 0);
                vertices[i] = v;
                this.vertexQ.push(v);
                continue;
            }
            Vertex vi = new Vertex(i, Integer.MAX_VALUE);
            vertices[i] = vi;
            this.vertexQ.push(vi);
            route[i] = -1;
        }
    }

    class Vertex implements Comparable<Vertex> {

        private int vertexNum;

        private double value;
        
        public void setValue(double value) {
            this.value = value;
        }

        public Vertex(int vertexNum, double value) {
            this.vertexNum = vertexNum;
            this.value = value;
        }

        /**
         * value值小vertex值大（若使用最大优先队列）
         */
        @Override
        public int compareTo(Vertex o) {
            if (this.value > o.value) {
                return -1;
            } else if (this.value < o.value) {
                return 1;
            } else {
                return 0;
            }
        }

        public int getVertexNum() {
            return vertexNum;
        }

        public double getValue() {
            return value;
        }
    }
    
    public static void main(String[] args) {
       WeightedGraph g = new WeightedGraph(5);
        
        g.addEdge(new Edge(0, 1, 10));
        g.addEdge(new Edge(0, 2, 5));
        g.addEdge(new Edge(1, 2, 2));
        g.addEdge(new Edge(1, 3, 1));
        g.addEdge(new Edge(2, 1, 3));
        g.addEdge(new Edge(2, 3, 9));
        g.addEdge(new Edge(2, 4, 2));
        g.addEdge(new Edge(3, 4, 4));        
        g.addEdge(new Edge(4, 0, 7));
        g.addEdge(new Edge(4, 3, 6));
        
        Dijkstra d = new Dijkstra();
        d.calculate(g, 0);
        
        int[] route = d.getRoute();
        Vertex[] values = d.getVertices();
        
        
        for (int i = 0;i < route.length;i++) {
            System.out.print(route[i] + " ");
        }
        
        System.out.println();
        
        for (int i = 0;i < values.length;i++) {
            System.out.print(values[i].getValue() + " ");
        }

    }

}
