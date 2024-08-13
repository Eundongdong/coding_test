package boj.dp.itojsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //점화식
        //d[i] = A[1] + A[2] + ... + A[i]
        //     = d[i-1] + A[i];
        // A배열 1부터 i까지의 합
        long[] d = new long[n+1];
        d[1] = arr[1];
        for(int i = 2; i <= n; i++){
            d[i] = d[i-1] + arr[i];
        }
        //testcase 만큼 돌기
       for(int k = 0; k < m; k++){
        //i번쨰 수부터 j번째 수까지의 합
        //A[i] + A[i+1] + ... A[j-1]+A[j]
        // = A[1] +A[2]+ ...A[j] - (A[1]+A[2]+...A[i-1])
        // = d[j] - d[i-1]
           st = new StringTokenizer(br.readLine());
           int i = Integer.parseInt(st.nextToken());
           int j = Integer.parseInt(st.nextToken());
           long ans = d[j] - d[i-1];
           System.out.println(ans);
       }
    }
}
