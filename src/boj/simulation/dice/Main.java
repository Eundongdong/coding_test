package boj.simulation.dice;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


class Solution{
    int[][] map;
    int[] commands;
    int r,c; //주사위의 현재 위치

    int[][] dirs = {{0,0},{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    int[] longPart = {0, 0, 0, 0}; // {바닥, 남, 윗면, 북}
    int[] shortPart = {0, 0, 0};   // {바닥, 동, 윗면}

    Solution(int[][] map, int[] commands, int r, int c){
        this.map = map;
        this.commands = commands;
        this.r = r;
        this.c = c;

    }


    void rolling(int direction){
        int[] tempLong = Arrays.copyOf(longPart, longPart.length);
        int[] tempShort = Arrays.copyOf(shortPart, shortPart.length);
        switch(direction){
            case 1: // 동쪽
                shortPart[0] = tempShort[1];
                shortPart[1] = tempShort[2];
                shortPart[2] = tempShort[0];
                longPart[0] = shortPart[0];
                longPart[2] = shortPart[2];
                break;
            case 2: // 서쪽
                shortPart[0] = tempShort[2];
                shortPart[1] = tempShort[0];
                shortPart[2] = tempShort[1];
                longPart[0] = shortPart[0];
                longPart[2] = shortPart[2];
                break;
            case 3: // 북쪽
                longPart[0] = tempLong[3];
                longPart[1] = tempLong[0];
                longPart[2] = tempLong[1];
                longPart[3] = tempLong[2];
                shortPart[0] = longPart[0];
                shortPart[2] = longPart[2];
                break;
            case 4: // 남쪽
                longPart[0] = tempLong[1];
                longPart[1] = tempLong[2];
                longPart[2] = tempLong[3];
                longPart[3] = tempLong[0];
                shortPart[0] = longPart[0];
                shortPart[2] = longPart[2];
                break;
        }
    }

    void solution(){
        for(int i = 0; i < commands.length; i++){
            //위치 옮기기
            int nr = r + dirs[commands[i]][0];
            int nc = c +dirs[commands[i]][1];

            //맵을 벗어나는 경우
            if (nr < 0 || nr >= map.length || nc < 0 || nc >= map[0].length) {
                continue;
            }
            rolling(commands[i]);
            // 이동한 칸의 처리
            if (map[nr][nc] == 0) {
                map[nr][nc] = longPart[0]; // 주사위의 바닥면을 지도에 복사
            } else {
                longPart[0] = map[nr][nc]; // 지도의 값을 주사위의 바닥면에 복사
                map[nr][nc] = 0; // 지도 값을 0으로 만듦
            }

            // 현재 주사위 위치 업데이트
            r = nr;
            c = nc;

            // 주사위의 윗면 출력
            System.out.println(longPart[2]);

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
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[]commands = new int[k];
        st=  new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            commands[i] = Integer.parseInt(st.nextToken());
        }
        Solution sol = new Solution(map, commands,diceR,diceC);
        sol.solution();

    }
}
