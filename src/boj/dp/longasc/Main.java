package boj.dp.longasc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.*;
import java.util.StringTokenizer;

class DP{
    int count;
    int max;

    public DP(int count, int max) {
        this.count = count;
        this.max = max;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = -1;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > max) {
                max = arr[i];
                cnt++;
            }
        }

        System.out.println(cnt);


    }
}
