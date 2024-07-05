package boj.stackqueue.괄호_회전하기;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Solution {
    public boolean isMatch(Deque<Character> q){
        Iterator iter = q.iterator();
        Deque<Character> stack = new ArrayDeque<>();
        while(iter.hasNext()){
            char tmp = (char) iter.next();
            if(tmp == '(' || tmp == '{' || tmp == '['){
                stack.push(tmp);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char cmp = stack.pop();
                if(0>= tmp - cmp || tmp - cmp >= 5){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public int solution(String s) {
        int answer = 0;
        int length = s.length();
        Deque<Character> q= new ArrayDeque<>();
        for(int i =0; i< length;i++){
            q.offer(s.charAt(i));
        }
        for(int i =0; i < length;i++){
            //쌍이 맞는지 확인
            if(isMatch(q))
                answer++;
            //한칸 옆으로 이동
            q.offer(q.poll());
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("[](){}"));
        System.out.println(solution.solution("}]()[{"));
        System.out.println(solution.solution("[)(]"));
        System.out.println(solution.solution("}}}"));
    }
}
