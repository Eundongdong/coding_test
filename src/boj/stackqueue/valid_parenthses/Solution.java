package boj.stackqueue.valid_parenthses;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public static boolean isValid(String s) {
        boolean answer = true;
        Deque<Character> stack = new ArrayDeque<>();
        for(int i =0; i< s.length();i++){
            char cmp = s.charAt(i);
            if(cmp =='(' || cmp =='[' ||cmp =='{'){
                stack.push(s.charAt(i));
            }else{
                if(stack.isEmpty()){
                    answer = false;
                    break;
                }

                char tmp = stack.peek();
                if(0<cmp - tmp &&cmp - tmp < 5){
                    stack.pop();
                }else{
                    answer = false;
                }
            }
        }
        if(!stack.isEmpty()){
            answer =false;
        }
        return answer;
    }
}
