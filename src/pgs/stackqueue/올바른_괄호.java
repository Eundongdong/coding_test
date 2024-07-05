package pgs.stackqueue;//PGS 올바른 괄호

import java.util.*;


class 올바른_괄호 {
    boolean solution(String s) {
        boolean answer = true;
        Deque<Character> stack = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            switch(s.charAt(i)){
                case '(':
                    stack.push('(');
                    break;
                case ')':
                    if(stack.isEmpty()){
                        answer = false;
                    }else{
                        stack.pop();
                    }
                    break;
            }

        }
        if(!stack.isEmpty()){
            answer = false;
        }

        return answer;
    }
}
