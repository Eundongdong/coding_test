package boj.dp.rgb;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] house = new int[n][3];
        for (int i = 0; i < n; i++) {
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            house[i] = s;
        }
        int[][] d = new int[n][3];
        d[0][0] = house[0][0]; //r
        d[0][1] = house[0][1]; //g
        d[0][2] = house[0][2];//b
        for (int i = 1; i < n; i++) {
            d[i][0] = Math.min(d[i-1][1], d[i-1][2]) + house[i][0];
            d[i][1] = Math.min(d[i-1][0], d[i-1][2]) + house[i][1];
            d[i][2] = Math.min(d[i-1][0], d[i-1][1]) + house[i][2];
        }

        int ans = Math.min(d[n-1][0], Math.min(d[n-1][1], d[n-1][2]));
        bw.write(ans + "\n");
        bw.flush();

    }
}
