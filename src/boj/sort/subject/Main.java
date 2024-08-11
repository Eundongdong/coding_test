package boj.sort.subject;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Score implements Comparable<Score> {
    String name;
    int korean;
    int english;
    int math;

    public Score(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKorean() {
        return korean;
    }

    public void setKorean(int korean) {
        this.korean = korean;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    @Override
    public String toString() {
        return "Score [name=" + name + ", korean=" + korean + ", english="+english + ", math="+math+"]";
    }

    @Override
    public int compareTo(Score o) {
        int firstSort = o.getKorean() - korean;
        if(firstSort != 0) return firstSort;
        int secondSort =  english - o.getEnglish();
        if(secondSort != 0) return secondSort;
        int thirdSort = o.getMath() - math;
        if(thirdSort != 0) return thirdSort;
        return name.compareTo(o.getName());
    }
}


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        Score[] scores = new Score[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            scores[i] = new Score(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(scores);
        for(Score s : scores){
            bw.write(s.getName());
            bw.newLine();
        }
        bw.flush();

        /*
            stream()을 이용한 풀이
            List<Score> scores = new ArrayList<>();
            <--값 담기 -->
            List<Score> sortedScores = scores.stream()
                .sorted(Comparator.comparingInt(Score::getKorean).reversed()
                        .thenComparingInt(Score::getEnglish)
                        .thenComparingInt(Score::getMath).reversed()
                        .thenComparing(Score::getName))
                .collect(Collectors.toList());

            sortedScores.forEach(score -> System.out.println(score.getName()));
         */


    }
}
