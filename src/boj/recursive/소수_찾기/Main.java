package boj.recursive.소수_찾기;

import java.util.ArrayList;

class Solution {

    ArrayList<Integer> arr = new ArrayList<>();
    public int solution(String numbers) {
        int answer = 0;
        //String을 한 자리씩 int로 변환
        int[] num = numbers.chars().map(n ->n-'0').toArray();
        boolean[] visited = new boolean[numbers.length()];
        permutation(num,new ArrayList<Integer>(),visited);
        for(int n : arr){
            if(n>=2 && isPrime(n)){
                answer++;
            }
        }
        return answer;
    }

    //소수 인지 확인하기
    boolean isPrime(int num){
        for(int i =2; i< num;i++){
            if(num %i ==0){
                return false;
            }
        }
        return true;
    }

    // 모든 순열 만들기
    void permutation(int[] num, ArrayList<Integer> curr,boolean[] visited){
        for(int i = 0; i< num.length;i++){
            if(visited[i]) continue;
            visited[i] = true;
            curr.add(num[i]);
            permutation(num,curr,visited);

            //값 넣기
            int ans = 0;
            for(int j = 0; j< curr.size();j++){
                ans += curr.get(j)* (int)(Math.pow(10,j));
            }
            if(!arr.contains(ans))
                arr.add(ans);

            visited[i] = false;
            curr.remove(curr.size() -1);

        }

    }


}
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String numbers= "17";
        System.out.println(sol.solution(numbers));
    }
}
