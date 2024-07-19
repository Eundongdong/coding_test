package boj.bfsdfs.단어변환;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 100000;
        int cnt =0;
        for(int i=0; i<words.length; i++){
            if(isValid(words[i],begin)){
                //모두 idx로 변경
                cnt = bfs(i,target ,words);
                if(cnt !=0){
                    answer = Math.min(answer, cnt);
                }
            }
        }
        if(cnt ==0){
            return 0;
        }
        return answer;
    }
    boolean isValid(String word, String target){
        int same = 0;
        for(int i=0; i<word.length(); i++){
            if(word.charAt(i)==target.charAt(i)){
                same++;
            }
        }
        return same == (target.length() -1);
    }

    int bfs(int idx, String target,String[] words){
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        queue.add(new int[]{idx,1});
        visited[idx] = true;
//        int cnt = 1;
        while(!queue.isEmpty()){
            int[] curr= queue.poll();
            if(words[curr[0]].equals(target)){
                return curr[1];
            }
            for(int i=0; i<words.length; i++){
                if(visited[i]) continue;
                if(isValid(words[i],words[curr[0]])){
                    queue.offer(new int[]{i,curr[1]+1});
                    visited[i] = true;
//                    cnt++;
                    if(words[i].equals(target)){
                        return curr[1]+1;
                    }
                }
            }
        }
        return 0;
    }


}

public class Main {
    public static void main(String[] args) {
        String begin ="hit";
        String target ="cog";
        String[] words = {"hot","dot","dog","lot","log","cog"};
        Solution solution = new Solution();
        System.out.println(solution.solution(begin, target, words));
    }
}
