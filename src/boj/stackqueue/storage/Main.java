package boj.stackqueue.storage;
import java.io.*;
import java.util.*;

public class Main {
    static class Top implements Comparable<Top> {
        int p, h;

        public Top(int p, int h) {
            this.p = p;
            this.h = h;
        }

        @Override
        public int compareTo(Top o) {
            return p - o.p;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 기둥 개수

        Top[] tops = new Top[N]; //기둥들 정보 저장
        int maxH = 0, max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken()); //기둥 위치
            int h = Integer.parseInt(st.nextToken()); //기둥 높이
            tops[i] = new Top(p, h);
        }
        Arrays.sort(tops); // 위치(p) 기준으로 정렬

        // 가장 높은 기둥의 인덱스 찾기
        for (int i = 0; i < N; i++) {
            if (maxH < tops[i].h) {
                maxH = tops[i].h;
                max = i;
            }
        }

        // 가장 높은 기둥을 기준으로 왼쪽 부분 계산
        int height = 0, move = 0, sum = 0;
        for (int i = 0; i <= max; i++) {
            if (height < tops[i].h) {
                sum += (tops[i].p - tops[move].p) * height;
                height = tops[i].h;
                move = i;
            }
        }
        sum += tops[max].h; // 가장 높은 기둥 자체의 면적 더하기

        // 가장 높은 기둥 이후의 기둥들 면적 계산 (오른쪽 부분)
        int idx = 0;
        height = 0;
        move = N - 1;
        for (int i = N - 1; i >= max; i--) {
            if (height < tops[i].h) {
                sum += (tops[move].p - tops[i].p) * height;
                height = tops[i].h;
                move = i;
                idx = i;
            }
        }
        sum += (tops[idx].p - tops[max].p) * tops[idx].h; // 남은 오른쪽 부분의 면적 더하기

        System.out.println(sum); // 최종 면적 출력
    }
}
