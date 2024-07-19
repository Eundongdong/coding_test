package boj.recursive.princess;

import java.awt.*;
import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    static int ans = 0;
    static HashSet<ArrayList<String>> hs = new HashSet<>();


    static boolean isConnected(ArrayList<String> curr){
        boolean[][] tempVisited = new boolean[5][5];
        Queue<String> queue = new LinkedList<>();
        queue.add(curr.get(0));
        int x = curr.get(0).charAt(0) - '0';
        int y = curr.get(0).charAt(2) - '0';
        tempVisited[y][x] = true;
        int count = 1;
        while (!queue.isEmpty()) {
            String current = queue.poll();
            for (int[] dir : dirs) {
                int nx = (current.charAt(0) - '0') + dir[0];
                int ny = (current.charAt(2) - '0') + dir[1];
                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && !tempVisited[ny][nx]) {
                    for (String c : curr) {
                        if ((c.charAt(0) -'0') == nx &&(c.charAt(2) -'0') == ny) {
                            tempVisited[ny][nx] = true;
                            queue.add(nx+"_"+ny);
                            count++;
                            break;
                        }
                    }
                }
            }
        }
        return count == 7;

    }




    // cnt = 이다솜파 수
    static void backtrack(char[][] map, ArrayList<String> curr, boolean[][] visited, int cnt, int x, int y) {
        if (curr.size() == 7){
            if(cnt >= 4 && isConnected(curr)) {
                Collections.sort(curr);
                hs.add(curr);
                ans++;
            }
            return;
        }

        if (0 <= x && x < 5 && 0 <= y && y < 5 && !visited[y][x] && curr.size() <= 7) {
            // break case


            // curr에 값 넣기
            curr.add(x + "_" + y);
            if (map[y][x] == 'S') {
                cnt++;
            }
            visited[y][x] = true;
            // recur
            for (int i = 0; i < 4; i++) {
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];
                backtrack(map, curr, visited, cnt, nx, ny);
            }
            visited[y][x] = false;
            curr.remove(curr.size() - 1);
            if (map[y][x] == 'S') {
                cnt++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[][] map = new char[5][5];
        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        boolean[][] visited = new boolean[5][5];
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                backtrack(map, new ArrayList<>(), visited, cnt, i, j);
            }
        }

        System.out.println(hs.size());
    }
}