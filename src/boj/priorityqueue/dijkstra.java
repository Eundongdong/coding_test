package boj.priorityqueue;

import java.util.*;

class Edge implements Comparable<Edge>{
    int node;
    int cost;
    public Edge(int node, int w) {
        this.node = node;
        this.cost = w;
    }
    @Override
    public int compareTo(Edge o){
        int first = this.cost - o.cost;
        if(first == 0)
            return this.node - o.node;
        return first;
    }

}


public class dijkstra {
    public static void main(String[] args) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(new Edge(2, 2), new Edge(4, 1)));
        graph.put(2, Arrays.asList(new Edge(5, 2), new Edge(3, 1), new Edge(6, 4)));
        graph.put(3, Arrays.asList(new Edge(6, 4)));
        graph.put(4, Arrays.asList(new Edge(3, 3), new Edge(7, 5)));
        graph.put(5, Arrays.asList(new Edge(8, 1)));
        graph.put(6, Arrays.asList(new Edge(5, 3)));
        graph.put(7, Arrays.asList(new Edge(6, 7), new Edge(8, 6)));
        graph.put(8, new ArrayList<>());

        int answer = dijkstra(graph, 1, 8, graph.size());
    }
    static int dijkstra(Map<Integer, List<Edge>> graph, int start, int end, int size){
        //초기설정
        int INF = Integer.MAX_VALUE;
        int[] dist = new int[size+1]; //중요!! dist 초기화 시키고 inf 넣기 == visited와 동일
        Arrays.fill(dist, INF);

        //시작점 예약
        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            //방문
            Edge curr = pq.poll();
            if(dist[curr.node] < curr.cost) continue; //현재 dist까지의 cost보다 큰 cost가 나오면 생략
            //예약
            //현재노드의 인접 노드들 순회
            for(Edge next :graph.get(curr.node)){
                int nextCost = dist[curr.node]+ next.cost;
                if(nextCost<dist[next.node]){
                    pq.add(new Edge(next.node, nextCost));
                    dist[next.node] = nextCost;
                }
            }
        }
        return dist[end];
    }

}
