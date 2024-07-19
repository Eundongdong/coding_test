package boj.bfsdfs.bipartite;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        //✅ color의 모든 요소를 -1로 초기화한다.
        int[] color = new int[n];
        Arrays.fill(color, -1);

        //✅ 모든 노드에 대해 반복한다.
        for (int i = 0; i < n; i++) {
            //✅ 만약 color[i] == -1 이라면 탐색을 시작한다.
            if (color[i] == -1) {
                //✅ 첫 노드를 0으로 표시하고 큐에 집어넣는다. BFS를 시작한다.
                Queue<Integer> queue = new ArrayDeque<>();
                color[i] = 0;
                queue.add(i);
                while (!queue.isEmpty()) {
                    int cur = queue.remove();
                    //✅ 현재 노드와 연결된 다른 노드들에 대해 반복한다.
                    for (int next : graph[cur]) {
                        //✅ 만약 color[next] == -1 이라면,
                        if (color[next] == -1) {
                            //✅ 다음 노드를 현재 노드와 다른 집합에 넣는다.
                            color[next] = 1 - color[cur];
                            //✅ 다음 노드를 큐에 추가한다.
                            queue.add(next);
                            //✅ 아닐 때, 만약 다음 노드가 현재 노드와 같은 집합에 이미 포함되어있으면 false를 리턴한다.
                        } else if (color[next] == color[cur]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}

public class Main{
    public static void main(String[] args) {
        int[][]graph = new int[][]{{1,3},{0,2},{1,3},{0,2}};
        Solution solution = new Solution();
        System.out.println(solution.isBipartite(graph));
    }

}