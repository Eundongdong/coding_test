package boj.stackqueue.주식가격;

import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int length = prices.length;
        int[] answer = new int[length];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i =0; i< length; i++){
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                int days = i - stack.peek();
                System.out.println(i+" : "+ stack.peek()+" : "+days);
                answer[stack.peek()] = days;
                stack.pop();
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int days = length - stack.peek()- 1;
            answer[stack.peek()] = days;
            stack.pop();
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[]{1, 2, 3, 2, 3})));
    }
}
