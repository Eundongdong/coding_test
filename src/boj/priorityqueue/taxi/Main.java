package boj.priorityqueue.taxi;
import java.util.*;
class Node implements Comparable<Node>{
    int idx;
    int cost;

    Node(int idx, int cost){
        this.idx = idx;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o){
        return this.cost - o.cost;
    }
}

class Solution {

    static List<Integer> costs = new ArrayList<>();
    static int n;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        this.n = n;
        Map<Integer,List<Node>> map = new HashMap<>();
        for(int i = 1; i<= n;i++){
            map.put(i,new ArrayList<>());
        }
        //인접리스트 만들기
        for(int i =0; i<fares.length;i++){
            int st = fares[i][0];
            int et = fares[i][1];
            int ct = fares[i][2];
            map.get(et).add(new Node(st,ct));
            map.get(st).add(new Node(et,ct));
        }
        List<Node> aTrail = dij(s,a,map);
        List<Node> bTrail = dij(s,b,map);

        int answer = costs.get(0)+costs.get(1);
        //중복된 부분 찾기
        for(int i = 0; i<aTrail.size();i++){
            if(aTrail.get(i) == bTrail.get(i)){
                answer -= aTrail.get(i).cost;
            }else{
                break;
            }
        }



        return answer;
    }

    public List<Node> dij(int start, int end, Map<Integer,List<Node>> map){
        Queue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        List<Node> res = new ArrayList<>();

        pq.add(new Node(start,0));
        dist[start] = 0;
        res.add(new Node(start,0));

        while(!pq.isEmpty()){
            Node now = pq.poll();
            for(Node next : map.get(now.idx)){
                int nextCost = now.cost + next.cost;
                if(dist[next.idx] > nextCost){
                    dist[next.idx] = nextCost;
                    pq.offer(new Node(next.idx,nextCost));
                    res.add(next);
                }
            }
        }
        costs.add(dist[end]);

        return res;
    }
}
public class Main {
}
