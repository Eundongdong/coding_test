package boj.bfsdfs.coinchange;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int answer = 100000;
        int n = coins.length;
        for(int i = 0; i < n;i++){
            int cnt = bfs(i,amount,coins);
            if(cnt>0){
                answer = Math.min(cnt,answer);
            }else if(cnt==0){
                return 0;
            }else{
                return -1;
            }
        }
        return answer;
    }

    int bfs(int start,int amount, int[] coins) {
        amount -= coins[start];
        if(amount < 0){
            return -1;
        }else if(amount == 0){
            return 0;
        }
        int cnt =0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(amount);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(cur ==0){
                return cnt;
            }else if(cur <0){
                return -1;
            }

            cnt++;
            for(int i = 0;i < coins.length;i++){
                int nextAmount = cur - coins[i];
                if(nextAmount >=0){
                queue.add(nextAmount);

                }
            }
        }
        return -1;
    }

}
public class Main {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        Solution solution = new Solution();
        System.out.println(solution.coinChange(coins, amount));
    }
}
