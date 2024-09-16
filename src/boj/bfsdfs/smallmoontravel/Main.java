package boj.bfsdfs.smallmoontravel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Solution sol = new Solution(map,n,m);
        System.out.println(sol.solution());

    }


}

class Solution{
    int[][] map;
    int n;
    int m;
    int[][] dirs={{1,-1},{1,0},{1,1}};
    public int solution(){
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            ans = Math.min(ans, bfs(i));
            System.out.println(ans);
        }
        return ans;
    }

    int bfs(int start){
        int ret = Integer.MAX_VALUE;
        boolean[][]visited=new boolean[n][m];
        Deque<int[]> q= new ArrayDeque<>();
        q.add(new int[]{0,start,-1,map[0][start]});
        visited[0][start]=true;
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int r = cur[0];
            int c = cur[1];
            int dir= cur[2]; //0,1,2  -1은 아무거나
            int cost = cur[3];
            if(r ==n-1) {
                ret = Math.min(ret,cost);
                continue;
            };
            for(int i=0;i<3;i++){
                if(dir ==i) continue;
                int nr=r+dirs[i][0];
                int nc=c+dirs[i][1];
                if(0<=nr && 0<=nc &&nr<n && nc<m ){

//                    System.out.println(cost);
                    q.add(new int[]{nr,nc,i, cost+map[nr][nc]});
                }
            }
        }
        return ret;

    }

    Solution(int[][] map, int n, int m){
        this.map = map;
        this.n = n;
        this.m = m;
    }
}
