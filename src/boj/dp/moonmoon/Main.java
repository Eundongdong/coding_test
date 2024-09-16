package boj.dp.moonmoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dirs = {{1, -1}, {1, 0}, {1, 1}};
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
        int[][][] dp = new int[n+1][m][2];
        for(int i = 0; i < m; i++) {
            dp[0][i][1] = Math.min(map[0][i], dp[0][i][1]);
        }
        for(int i = 1; i < m; i++) {
            for(int j = 0; j < 3; j++) {
                if(dp[i-1][0] == j) continue;
                if(dp[i-1][1]+ map[i +dirs[i][0]][])
            }
        }




    }
}
