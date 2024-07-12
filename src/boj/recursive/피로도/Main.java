package boj.recursive.피로도;

import java.util.ArrayList;

class Solution {
    static int answer = -1;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
//        ArrayList<Boolean> visitedList = new ArrayList<>();

        backtrack(k, dungeons, visited);
        return answer;
    }
    void backtrack(int k, int[][] dungeons, boolean[] visited) {
        for (int i = 0; i < dungeons.length; i++) {
            //방문한 적 있다면 패스
            if (visited[i]) continue;

            //최소 피로도를 만족한다면
            if(dungeons[i][0] <= k) {
                //방문 표시 후 나아가기
                visited[i] = true;
                backtrack(k -dungeons[i][1], dungeons,visited);
                visited[i] = false;
            }else{
                continue;
            }
        }
        int cnt =0;
        for (boolean b : visited) {
            if (b) {
                cnt++;
            }
        }
        answer = Math.max(answer,cnt);
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int k = 80;
        // 최소 피로도 , 소모 피로도
        int[][] dungeons = new int[][]{{80,20},{50,40},{30,10}};
        System.out.println(solution.solution(k, dungeons));
    }
}
