package boj.stackqueue.기능개발;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static int[] solution(int[] progresses, int[] speeds) {


        //Deque로 풀이
        /*
         1. while !deque.isEmpty 까지 반복
         2. 속도 모두 증가시키기
         3. 맨 앞이 100이면 poll (반복)
         */
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> answer = new ArrayDeque<>();

        for(int p : progresses){
            stack.add(p);
        }
        //배열 풀이
        int idx =0;
        while(idx < progresses.length){
            int count = 0;
            //스피드 더하기
            for(int i = 0; i < progresses.length; i++){
                progresses[i] += speeds[i];
            }
            //100프로인가?
            while(idx < progresses.length && progresses[idx] >= 100){
                count++;
                idx++;
            }
            if(count>0){
                answer.add(count);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] progresses = new int[]{93,30,55};
        int[] speeds = new int[]{1,30,5};

        System.out.println(solution(progresses,speeds));

    }
}
