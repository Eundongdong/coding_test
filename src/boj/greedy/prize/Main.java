package boj.greedy.prize;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(A);
        Arrays.sort(B);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += B[i]*A[n-i-1];
        }
        System.out.println(ans);
    }
}
