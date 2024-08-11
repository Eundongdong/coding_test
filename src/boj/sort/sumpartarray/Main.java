package boj.sort.sumpartarray;

import java.util.*;

class Solution {

    public int calSum(int start, int end, int[]s){
        int sum = 0;
        for(int i = start; i <= end;i++){
            sum+=s[i];
        }
        return sum;
    }


    public int[] solution(int[] s, int k) {
        int[] answer = {0,1000000};
        int start = 0;
        int end = 1;

        while(start <s.length && end < s.length){
            int sum = calSum(start,end,s);
            if(sum <= k){
                if(sum ==k){
                    if(answer[1]-answer[0] > end -start){

                        answer[0] = start;
                        answer[1] = end;
                    }
                }
                end++;
            }else{
                start++;
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        int[]seq = {1,1,1,2,3,4,5};
        int k = 5;
        Solution solution = new Solution();
        System.out.println(solution.solution(seq, k)[0]);
    }
}
