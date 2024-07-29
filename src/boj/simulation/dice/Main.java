package boj.simulation.dice;

import java.io.*;
import java.util.StringTokenizer;


class Solution{
    int[][] map;
    int[] commands;

    int[][] dirs = {{0,0},{0,-1},{0,1},{1,0},{-1,0}};
    int[] longPart = {0,0,0,0};
    int[] shortPart = {0,0,0};

    Solution(int[][] map, int[] commands){
        this.map = map;
        this.commands = commands;
    }

    void solution(){
        //명령 수행하기
        int nowR = 0;
        int nowC = 0;
        int dir = 1; //1일때 long, -1일때 short
        int idx = 1; //초기 위치

        for(int i = 0; i < commands.length; i++){
            if(nowR + dirs[commands[i]][0] < 0 && nowC + dirs[commands[i]][1] < 0) continue;
            //위치 옮기기
            nowR += dirs[commands[i]][0];
            nowC += dirs[commands[i]][1];
            //상하 굴리기
            if(commands[i] >=3){
                //주사위 굴리기(긴 부분
                //현위치가 긴부분에 위치한다면
                if(dir ==1){
                    idx = (idx + dirs[commands[i]][0] ) %4;
                }else{
                //짧은 부분에 위치한다면
                    dir = 1;
                    idx = (1+ dirs[commands[i]][0] ) %4;
                }
                



            }else{
                //좌우 굴리기 (짧은 부분
                idx = (idx + dirs[commands[i]][1] ) %3;
            }

        }


    }

}





public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int diceR = Integer.parseInt(st.nextToken());
        int diceC = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int commandLength = Integer.parseInt(st.nextToken());
        int[]commands = new int[commandLength];
        st=  new StringTokenizer(br.readLine());
        for (int i = 0; i < commandLength; i++) {
            commands[i] = Integer.parseInt(st.nextToken());
        }
        Solution sol = new Solution(map, commands);

    }
}
