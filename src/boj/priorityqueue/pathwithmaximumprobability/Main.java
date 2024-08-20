package boj.priorityqueue.pathwithmaximumprobability;
//341 ~50

import java.util.*;

class Node implements Comparable<Node>{
    double succ; //현재 노드까지의 확률
    int idx;

    Node(int idx,double succ){
        this.succ = succ;
        this.idx = idx;
    }

    @Override
    public int compareTo(Node o){
//        return o.succ - this.succ >0 ? 1:-1; //확률 높은 순서대로
        return Double.compare(o.succ, this.succ);
    }

}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<Node>> map = new HashMap<>();
        for(int i = 0; i<n;i++){
            map.put(i, new ArrayList<>());
        }
        for(int i = 0; i< edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            map.get(u).add(new Node(v,prob));
            map.get(v).add(new Node(u,prob));
        }

        double[] pos = new double[n]; //pos[i] 위치까지의 확률 / -1으로 초기화
        Arrays.fill(pos,0);
        pos[start_node] = 1;
        Queue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start_node,1));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(now.idx ==end_node) return now.succ;
            for(Node next : map.get(now.idx)){
                double nextSucc = now.succ * next.succ;
                if(nextSucc > pos[next.idx]){
                    pos[next.idx] = nextSucc;
                    pq.offer(new Node(next.idx,nextSucc));
                }
            }

        }
        return 0;

    }
}
public class Main {
    static Solution solution = new Solution();
    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2},{0,2}};
        int n = 3;
        double[] succProb = {0.5,0.5,0.2};
        int start =0;
        int end = 2;
        double ans = solution.maxProbability(n, edges, succProb, start, end);
        System.out.println(ans);
    }
}
