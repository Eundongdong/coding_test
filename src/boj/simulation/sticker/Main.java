package boj.simulation.sticker;


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution{

    private int ans = -1;
    private int n;
    private int[][] arr = new int[2][];

    public int solution(){
        func(0,0,0);
        func(1,0,0);
        func(-1,0,0);

        return ans;
    }


    public void func(int curr, int idx, int sum){
       //base condition
        // ans에 값 넣기
        if(idx == n){
            ans = Math.max(ans, sum);
            return;
        }
        if(curr != -1){
            sum+=arr[curr][idx];
        }
        switch(curr){
            // 패스
            case -1:
                func(0, idx+1, sum);
                func(1, idx+1, sum );
            break;
            case 0:
                func(-1, idx+1, sum);
                func(1,idx+1,sum);
            break;

            case 1:
                func(-1,idx+1,sum);
                func(0, idx+1, sum);
            break;
        }
    }

    public int getAns() {
        return ans;
    }

    public void setAns(int ans) {
        this.ans = ans;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int[][] getArr() {
        return arr;
    }

    public void setArr(int[][] arr) {
        this.arr = arr;
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            Solution s = new Solution();
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n];
            for(int k = 0; k < 2; k++){
                    StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    arr[k][j] = Integer.parseInt(st.nextToken());
                }
            }
            s.setArr(arr);
            s.setN(n);
            int maxAns = s.solution();
            sb.append(maxAns).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
