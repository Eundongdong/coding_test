//https://school.programmers.co.kr/learn/courses/30/lessons/72410#
//PGS 2021 카카오 기출
//풀이시간 : 40분
//난이도 : 중 (IDE있으면 디버깅 모드로 쉽게 푸는 것 같다)

package boj.stackqueue.newID;

import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";

        if(new_id.isEmpty()){
            return "aaa";
        }

        //1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        answer = new_id.toLowerCase();

        //2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        Deque<Character> stack = new ArrayDeque<>();
//        3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        boolean beforeDot = false;
        for(char c : answer.toCharArray()) {
            if(Character.isLetter(c) || Character.isDigit(c)||c == '-' || c == '_' || c =='.') {
                if(c == '.'){
                    if(beforeDot){
                        continue;
                    }else{
                        beforeDot = true;
                    }
                }else{
                    beforeDot = false;
                }
                stack.add(c);
            }
        }




//        4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if(!stack.isEmpty() && stack.peekFirst() =='.'){
            stack.pollFirst();
        }
        if(!stack.isEmpty() && stack.peekLast() =='.'){
            stack.pollLast();
        }

        //5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        //빈 문자열 해결
        if(stack.isEmpty()){
            return "aaa";
        }

        //6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
//                만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if(stack.size() >= 16){
            while(stack.size()>15){
                stack.pollLast();
            }
            if(stack.peekLast() =='.'){
                stack.pollLast();
            }
        }

//        7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        if(stack.size()<=2){
            char lastChar = stack.peekLast();
            while(stack.size()<3){
                stack.add(lastChar);
            }
        }


        //Deque -> String 변환
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.poll());
        }

        return sb.toString();
    }
}

class Main{
    public static void main(String[] args) {
        Solution sol = new Solution();
//        System.out.println(sol.solution(""));
        //"...!@BaT#*..y.abcdefghijklm"
        //"z-+.^."
        String[] testcase = new String[]{"=.=","123_.def","abcdefghijklmn.p"};
        for(String s : testcase){
            System.out.println(sol.solution(s));
        }
    }
}