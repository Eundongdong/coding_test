package boj.greedy.makereststation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        List<Integer> stations = new ArrayList<>();
        List<List<Integer>> dp = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n;i++){
            stations.add(Integer.parseInt(st.nextToken()));
        }
        stations.add(l);
        dp.add(stations);
        for(int i = 0; i < m; i++){
            List<Integer> now = dp.get(i);
            int max = now.stream().max(Integer::compareTo).get();
            int maxidx = now.indexOf(max);
            int dived = max/2;
            boolean flag = max%2 ==0;
            now.add(maxidx,dived);
            if(!flag){
                now.add(maxidx,dived+1);
            }else{
                now.add(maxidx,dived);
            }
            now.remove(maxidx+2);
            dp.add(now);
        }
        List<Integer> result = dp.get(dp.size()-1);
        int ansMin = Collections.min(result);
        System.out.println(ansMin);
    }
}
