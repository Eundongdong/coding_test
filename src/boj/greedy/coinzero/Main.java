package boj.greedy.coinzero;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int budget = k;
        int ans = 0;
        for(int i = n-1; i >= 0; i--) {
            if(budget == 0) break;
            if(budget / coins[i] !=0){
                int tmp = budget % coins[i];
                ans += budget / coins[i];
                budget = tmp;
            }
        }
        bw.write(ans+"\n");
        bw.flush();
        bw.close();
    }
}
