package boj.hash.teach;

import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String[] arr = new String[n];
        List<Map<Character,Integer>> mapList = new ArrayList<>();
        List<Integer> charCountList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
            Map<Character,Integer> map = new HashMap<>();
            for(char c : arr[i].toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            mapList.add(map);
        }







    }
}
