package boj.sort.djmaxranking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //현재 랭킹에 들어간 점수
        int score = Integer.parseInt(st.nextToken()); // 태수의 점수
        int p= Integer.parseInt(st.nextToken()); //랭킹리스트에 올라갈 수 있는
        int[] ranking = new int[n];
        st= new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ranking[i] = Integer.parseInt(st.nextToken());
        }
        int prevScore = ranking[0];
        int sameScoreCnt=0;
        for (int i = 0; i < n; i++) {
            //100 100 90 (89)
            if(ranking[i] <= score && i <=p){
                if(i ==n-1) System.out.println(-1);
                if(ranking[i]==prevScore){
                    System.out.println(i+1-sameScoreCnt);
                }else{
                    System.out.println(i+1);
                }
                return;
            }
            if(ranking[i]==prevScore){
                sameScoreCnt++;
            }else{
                sameScoreCnt=0;
            }
            prevScore = ranking[i];
        }

        System.out.println(-1);
        //2. 랭킹 밀어내기 필요

    }
}
