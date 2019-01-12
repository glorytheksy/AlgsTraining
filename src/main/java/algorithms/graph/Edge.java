package algorithms.graph;

/**
 * 
 * @ClassName Edge
 * @Description 权重边
 * @author yxmfight
 * @Date 2017年12月16日 下午8:36:56
 * @version 1.0.0
 */
public class Edge implements Comparable<Edge> {

    // 一个顶点
    private int v1;
    
    // 另一个顶点
    private int v2;
    
    // 权重
    private double w;
    
    
    public Edge(int v1, int v2, double weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.w = weight;
    }
    
    public int getFrom() {
        return v1;
    }
    
    public int getTo() {
        return v2;
    }
    
    public double weight() {
        return this.w;
    }
    
    public int either() {
        return v1;
    }
    
    public int other(int vertex) {
        if (v1 == vertex) {
            return v2;
        } else if (v2 == vertex) {
            return v1;
        } else {
            throw new RuntimeException("");
        }
    }
    
    public int compareTo(Edge e) {
        if (e.weight() < this.weight()) {
            return 1;
        } else if (e.weight() > this.weight()) {
            return -1;
        } else {
            return 0;
        }
    }
}


