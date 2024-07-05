package boj.stackqueue.두_큐_합_같게_만들기;

import java.util.*;

class Solution {

    static long sum1;
    static long sum2;


    void popInsert(boolean flag, Deque<Integer> q1, Deque<Integer> q2){
        if(flag){
            int tmp = q1.pop();
            q2.offer(tmp);
            sum1 -= tmp;
            sum2 += tmp;
        }else{
            int tmp = q2.pop();
            q1.offer(tmp);
            sum1 += tmp;
            sum2 -= tmp;
        }
    }

    public int solution(int[] queue1, int[] queue2) {
        sum1 = Arrays.stream(queue1).sum();
        sum2 = Arrays.stream(queue2).sum();
        Deque<Integer>  q1 = new ArrayDeque<>();
        for(int q: queue1){
            q1.offer(q);
        }
        Deque<Integer>  q2 = new ArrayDeque<>();
        for(int q: queue2){
            q2.offer(q);
        }

        boolean flag = true;

        for (int i = 0; i < (queue1.length) *3; i++) {
            if(sum1 ==sum2){
                return i;
            }else if(sum1 < sum2){
                flag = false;
            }else{
                flag = true;
            }
            popInsert(flag, q1,q2);
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1}));
        System.out.println(solution.solution(new int[]{1,2,1,2}, new int[]{1,10,1,2}));
    }
}