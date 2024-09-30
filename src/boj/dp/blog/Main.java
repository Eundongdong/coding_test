package boj.dp.blog;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //sliding window
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[x];
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < x; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(i < n){
                sum += arr[i];
            }
        }
        int maxSum = sum;
        int count = 1; // 최대 방문자 수를 가진 구간의 개수

        // 슬라이딩 윈도우를 이용해 나머지 구간을 탐색
        for (int i = 1; i <= x - n; i++) {
            sum = sum - arr[i - 1] + arr[i + n - 1];

            if (sum > maxSum) {
                maxSum = sum;
                count = 1; // 새로운 최대값이 나왔으므로 카운트 초기화
            } else if (sum == maxSum) {
                count++; // 동일한 최대값이 나오면 카운트 증가
            }
        }

        if (maxSum == 0) {
            bw.write("SAD\n");
        } else {
            bw.write(maxSum + "\n");
            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();

    }
}
