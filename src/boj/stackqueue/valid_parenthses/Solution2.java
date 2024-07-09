package boj.stackqueue.valid_parenthses;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {

    public static boolean isValid(String s){
        Deque<Character> stack = new ArrayDeque<>();
        for(int i =0 ; i < s.length(); i++){
            char cmp = s.charAt(i);
            if(cmp == '('){
                stack.add(')');
            }else if(cmp =='['){
                stack.add(']');
            }else if(cmp =='{'){
                stack.add('}');
            }else{
                if(!stack.isEmpty() &&stack.peekLast() == cmp){
                    stack.pollLast();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {

    }
}
