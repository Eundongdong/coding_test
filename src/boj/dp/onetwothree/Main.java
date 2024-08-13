package boj.dp.onetwothree;

import java.util.*;
import java.io.*;


public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());


        int[] d = new int[11];
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;

        for (int n = 4; n < 11;n++){
            d[n] = d[n-1]  + d[n-2] + d[n-3] ;
        }

        for(int i = 0; i<t;i++){
            int ans = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(d[ans]));
            bw.newLine();
        }
        bw.flush();



    }
}