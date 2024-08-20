package boj.stackqueue.storage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr=  new int [1002];
        int[] left = new int[1002];
        int[] right = new int[1002];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        left[0] = arr[0];
        //왼쪽 비교
        for(int i = 1; i<=1000;i++){
            left[i] = Math.max(left[i-1], arr[i]);
        }
        //오른쪽 비교
        for(int i = 1000;i>0;i--){
            right[i] = Math.max(right[i+1], arr[i]);
        }
        int ans = 0;
        for(int i = 0; i < 1002; i++){
            ans += Math.min(left[i], right[i]);
        }
        System.out.println(ans);

    }
}
