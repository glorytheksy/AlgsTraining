package jianzhiOffer_second_time;

import algorithms.graph.Graph;
import utils.Queue;

public class BFS {
    
    /**
     * 
     * @Description 根据算法导论， 为了跟踪遍历进度，可以对图中点设置 黑白灰三种颜色，
     *              我们这里不对遍历进行跟踪，省去这个流程。
     *              每个点进出队列一次;出列时，每个点的邻接链表扫描一次，邻接链表总数目为O(E);
     *              时间复杂度:O(V+E)
     * @param graph
     * @param src
     */    
    public void solution(Graph graph, int src) {
        // 存储前驱节点
        Integer [] pi = new Integer [graph.getV()];  
        // 距离源头的距离
        Integer [] distance = new Integer [graph.getV()];
        // 遍历队列
        Queue<Integer> pointQue = new Queue<Integer>();
        pi[src]  = -1;
        distance[src] = 0;
        pointQue.add(src);
                
        while(!pointQue.isEmpty()) {
            int center = pointQue.poll();
            Iterable<Integer> adjPointlist = graph.adj(center);
            for (int e : adjPointlist) {
                if (null != pi[e]) {
                    pi[e] = center;
                    pointQue.add(e);
                    distance[e] = distance[center] + 1;
                }                
            }
        }
    }

}
