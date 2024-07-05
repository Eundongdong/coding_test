package pgs.dfsbfs;

import java.util.*;
public class TargetNumber {
        static int count =0;
        public static void dfs(int[]numbers,int idx,int sum,int target){
            if(idx == numbers.length){
                if(sum == target)
                    count++;
                return;

            }
            dfs(numbers,idx+1,sum + numbers[idx],target);
            dfs(numbers,idx+1,sum - numbers[idx],target);

            return;
        }


        public static int solution(int[] numbers, int target) {
            dfs(numbers,0,0,target);
            return count;
        }

    public static void main(String[] args) {
        int[]numbers = new int[]{1,1,1,1,1};
        int target = 3;
        System.out.println(solution(numbers,target));
    }
}
