package boj.bfsdfs.covid;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


//방문처리 X
class Solution {
    int[][]dirs ={{-1,0},{1,0},{0,1},{0,-1}};

    boolean bfs(int startR,int startC,char[][] onePlace){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startR, startC, 0});
        //방문처리
        onePlace[startR][startC]='X';

        while(!q.isEmpty()){
            int[] currSp = q.poll();
            int r = currSp[0];
            int c = currSp[1];
            int cnt = currSp[2];

            if(cnt ==2){
                return true;
            }
            for(int i = 0; i< 4; i++){
                int nr = r + dirs[i][0];
                int nc = c + dirs[i][1];
                if(0<=nr&& nr<onePlace.length && 0<=nc && nc<onePlace[0].length){
                    if(onePlace[nr][nc] != 'X'){
                        //방문 처리
                        onePlace[nr][nc] = 'X';
                        q.offer(new int[]{nr, nc, cnt+1});
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }


    int splitPlace(char[][]onePlace){
        //5*5 돌면서 영역 넣기
        for(int i =0; i<5;i++){
            for(int j = 0; j <5;j++){
                //벽이 아니라면
                if(onePlace[i][j] !='X'){
                    if(!bfs(i,j,onePlace)){
                        return 0;
                    }
                }
            }
        }
        return 1;
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for(int i = 0; i<5;i++){
            //대기실 한 공간 만들기
            char[][] onePlace = new char[5][5];
            for(int j = 0; j <5;j++){
                onePlace[j] = places[i][j].toCharArray();
            }
            //bfs로 공간 영역 나누기
            //5*5번 반복
            int nowAns = splitPlace(onePlace);
            answer[i]= nowAns;

        }
        return answer;
    }



}
public class Main {
}
