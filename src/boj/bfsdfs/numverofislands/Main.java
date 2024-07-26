package boj.bfsdfs.numverofislands;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    int cnt = 0;
    public int numIslands(char[][] grid) {
        //for문을 모든 맵을 돌면서 bfs 진행
        for(int i = 0; i < grid.length;i++ ){
            for(int j = 0; j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    cnt++;
                    bfs(i,j,grid);
                }
            }
        }
       return cnt;


    }

    void bfs(int startr, int startc,char[][] grid){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startr,startc});
        grid[startr][startc]='0'; //방문 표시
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r= curr[0];
            int c = curr[1];
            for(int i = 0; i< 4; i++){
                int nr = r + dirs[i][0];
                int nc = c + dirs[i][1];
                if(0<=nr&& nr < grid.length && 0<=nc && nc<grid[0].length ){
                    if(grid[nr][nc] =='1'){
                        grid[nr][nc] = '0';
                        q.offer(new int[]{nr,nc});
                    }
                }
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        Solution solution = new Solution();
        System.out.println(solution.numIslands(grid1));

    }
}
