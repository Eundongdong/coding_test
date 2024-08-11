package boj.sort.eatoreaten;

import java.util.*;
import java.io.*;

class Solution{
    int alen;
    int blen;
    int[] a;
    int[] b;

    Solution(int alen,int blen, int[]a, int[]b){
        this.alen = alen;
        this.blen = blen;
        this.a=a;
        this.b=b;
    }

    public int findIdx(int[]a, int now){
        int idx = a.length /2;
        // case 별로 구하기
        if(a[idx] == now){
            //더 큰 수가 나온다면 그 전 idx까지 return
            while(idx < a.length && a[idx] ==now){
                idx++;
            }
            return idx-1;

        }else if(a[idx] > now){
            //최초의 같거나 작은 수가 나올때까지 idx--
            while(idx>0 && a[idx]>now){
                idx--;
            }
            return idx;
        }else{
            //최초의 큰 수가 나올때까지 idx++
            while(idx<a.length && a[idx]<=now){
                idx++;
            }
            return idx-1;
        }
    }

    public int solution(){
        int ans = 0;
        //1. 정렬
        Arrays.sort(a);
        Arrays.sort(b);

        //2. B를 하나씩 순회
        for(int i = 0; i< b.length;i++){
            int nowB = b[i];
            int idx = findIdx(a,nowB);
            ans += a.length - idx -1;
        }

        return ans;
    }

}


public class Main{
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i< n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int alen = Integer.parseInt(st.nextToken());
            int blen = Integer.parseInt(st.nextToken());
            int[] a = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] b = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            Solution sol = new Solution(alen,blen,a,b);
            bw.write(String.valueOf(sol.solution()));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
