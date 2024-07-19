package boj.bfsdfs.network;


import java.util.Stack;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int cnt = 0;
        boolean[]visited = new boolean[n];
        for(int i = 0; i < n; i++){
            cnt += dfs(i,computers,visited);
        }
        System.out.println(cnt);
        return answer;


    }


    public int dfs(int idx,int[][] computers, boolean[] visited) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(idx);
        if (visited[idx]) {
            return 0;
        }
        visited[idx] = true;
        while (!stack.isEmpty()) {
            int curr = stack.pop();

            for (int i = 0; i < computers[curr].length; i++) {
                if (!visited[i] && computers[curr][i] == 1) {
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
        return 1;
    }
}
public class Main {

    public static void main(String[] args) {
        int[][] computers = new int[][] {{1,1,0},{1,1,0},{0,0,1}};
        int[][] computers2 = new int[][] {{1,1,0},{1,1,1},{0,1,1}};
        Solution solution = new Solution();
        System.out.println(solution.solution(3,computers2));
    }
}
