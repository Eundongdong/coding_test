package boj.dp.step;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] s = new int [n+1];
        s[0] = 0;
        for (int i = 1; i <= n; i++) {
            s[i] = Integer.parseInt(br.readLine());
        }
        int[][] d = new int[n+1][3];
        //d[k][1] = max(D[k-2][1], D[k-2][2]) + s[k]
        //d[k][2] = d[k-1][1] +s[k]
        d[1][1] = s[1];
        d[1][2] = 0;
        if(n<2){
            bw.write(String.valueOf(Math.max(d[n][1], d[n][2])));
            bw.flush();
            return;
        }
        d[2][1] = s[2];
        d[2][2] = s[1]+s[2];
        for (int i = 3; i <= n; i++) {
            d[i][1] = Math.max(d[i-2][1], d[i-2][2]) +s[i];
            d[i][2] = d[i-1][1] + s[i];
        }

        bw.write(String.valueOf(Math.max(d[n][1], d[n][2])));
        bw.flush();
    }
}
