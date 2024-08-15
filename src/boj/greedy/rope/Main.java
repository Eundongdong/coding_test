package boj.greedy.rope;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ropes = new int[n];
        for (int i = 0; i < n; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(ropes); //오름차순으로 정렬
        int weight = -1;
        for (int i = 0; i < n; i++) {
            weight = Math.max(weight, ropes[i] * (n-i));
        }
        System.out.println(weight);
    }
}
