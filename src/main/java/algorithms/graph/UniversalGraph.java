package algorithms.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UniversalGraph
 * @Description 根据uda的图模型python实现改编，一种统一的图实现方式
 * @author yxmfi
 * @Date 2018年9月26日 下午3:33:28
 * @version 1.0.0
 */
public class UniversalGraph {
    
    private List<Node> nodeList = new ArrayList<Node>();
    private List<Edge> edgeList = new ArrayList<Edge>();
    
    public UniversalGraph(List<Node> nodeList, List<Edge> edgeList) {
        this.nodeList = nodeList;
        this.edgeList = edgeList;        
    }
    
    public void insertNode(int newNodeVal) {
        this.nodeList.add(new Node(newNodeVal));
    }
    
    public void insertEdge(int newEdgeVal, Node nodeFrom, Node nodeTo) {
        Edge newEdge = new Edge(newEdgeVal, nodeFrom, nodeTo);
        nodeFrom.edgeList.add(newEdge);
        nodeTo.edgeList.add(newEdge);
        edgeList.add(newEdge);
    }
    
    public void getAdjacencyList() {
        
    }
        """Don't return any Node or Edge objects!
        You'll return a list of lists.
        The indecies of the outer list represent
        "from" nodes.
        Each section in the list will store a list
        of tuples that looks like this:
        (To Node, Edge Value)"""
        return []
    
    public void getAdjacencyMatrix():
        """Return a matrix, or 2D list.
        Row numbers represent from nodes,
        column numbers represent to nodes.
        Store the edge values in each spot,
        and a 0 if no edge exists."""
        return []
    
        
    private class Edge {
        @SuppressWarnings("unused")
        int value;
        @SuppressWarnings("unused")
        Node nodeFrom;
        @SuppressWarnings("unused")
        Node nodeTo;
        
        public Edge(int value, Node nodeFrom, Node nodeTo) {
            this.value = value;
            this.nodeFrom = nodeFrom;
            this.nodeTo = nodeTo;
        }
    }
    
    private class Node {
        @SuppressWarnings("unused")
        int value;
        List<Edge> edgeList = new ArrayList<Edge>();
        
        public Node(int value) {
            this.value = value;
        }
    }
    
    
    
    
}
