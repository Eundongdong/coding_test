package boj.bfsdfs.gamemap;

import java.util.ArrayDeque;
import java.util.Queue;

import java.util.*;
class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    int anscnt =0;
    public int solution(int[][] maps) {
        int answer = 0;

        if(maps[0][0] !=1){
            return -1;
        }else{
            bfs(0,0,maps);
        }

        return anscnt;
    }

    void bfs(int startr, int startc, int[][]map){
        if(map[startr][startc] !=1) { //올바른 위치라면?
            anscnt = -1;
            return;
        }
        map[startr][startc] = 0; // 방문처리
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startr, startc,1});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int row = cur[0];
            int col = cur[1];
            int nowcount = cur[2];
            //종료조건
            if(row == map.length-1 && col == map[0].length-1){
                anscnt = nowcount;
                return;
            }
            for(int[] dir : dirs){
                int nrow = row + dir[0];
                int ncol = col + dir[1];
                if(0<=nrow && nrow<map.length && 0<=ncol && ncol<map[0].length){
                    if(map[nrow][ncol] == 1){
                        q.offer(new int[]{nrow,ncol,nowcount+1});
                    }
                }
            }
        }
        anscnt= -1;

    }
}

public class Main {
    public static void main(String[] args) {

    }
}
