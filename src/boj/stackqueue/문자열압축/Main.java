package boj.stackqueue.문자열압축;

import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 1000;
        int L = s.length();
        for(int i= 1; i<= L;i++){
            // i 는 기준의 길이
            Deque<String> st = new ArrayDeque<>();
            //기준 덱의 개수
            int stL = L % i ==0 ? L/i : L/i +1;
            //기준의 길이에 따른 s 잘라 넣기
            for(int j = 0; j < stL ; ++j){
                if((j+1)*i >=L){
                    st.offer(s.substring(j*i));
                }else{
                    st.offer(s.substring(j*i,(j+1)*i));
                }
            }

            int cmp = 0;
            //압축tmp 담을 deque
            Deque<String> zip = new ArrayDeque<>();
            //기준을 토대로 s 압축하기
            while(!st.isEmpty()){
                //zip은 최근 들어온 거 st는 앞에서부터 비교
                if(!zip.isEmpty() && !Objects.equals(zip.peek(), st.peekFirst())){
                    if(zip.size()==1){
                        cmp+= zip.peek().length();
                    }else{
                        cmp += zip.peek().length() + String.valueOf(zip.size()).length();
                    }
                    zip.clear();
                }
                zip.offer(st.poll());
            }
            if(!zip.isEmpty()){
                if(zip.size()==1){
                    cmp +=zip.peek().length();
                }else{
                    cmp+=zip.peek().length()+ String.valueOf(zip.size()).length();;
                }
            }
            answer = Math.min(answer,cmp);
        }


        return answer;
    }
}

public class Main{
    public static void main(String[] args){
        Solution solution = new Solution();
        String s = "aabbaccc";
        System.out.println(solution.solution(s));
    }
}
