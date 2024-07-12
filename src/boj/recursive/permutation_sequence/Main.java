package boj.recursive.permutation_sequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class Solution {

    public String getPermutation(int n, int k) {
        List<Integer> res = new ArrayList<>();
        int[] nums = new int[n];
        for(int i = 0;i<n;i++){
            nums[i] = i+1;
        }
        int length = nums.length;
        boolean[] visited = new boolean[length];
//        HashSet
        backtrack(new ArrayList<>(),nums,visited, res);
        //k 번째 값 구하기
        Collections.sort(res);
        return res.get(k-1).toString();

    }

    // 순열을 만들어서 result에 추가하는 함수
    void backtrack(List<Integer> curr, int nums[],boolean[] visited, List<Integer> res ){
        //base case
//        if(curr.size() == nums.length){
//            //curr로 String 만들기
//            int ans = 0;
//            for(int i = 0; i<curr.size();i++){
//                ans += curr.get(i) * (Math.pow(10,i));
//            }
//            res.add(ans);
//            return;
//        }


        //recursive call
        for(int i =0;i<nums.length;i++){
            if(visited[i]) continue;


            curr.add(nums[i]); // add
            visited[i] = true;

            backtrack(curr,nums,visited,res);

            //curr로 String 만들기
            int ans = 0;
            for(int j = 0; j<curr.size();j++){
                ans += curr.get(j) * (Math.pow(10,j));
            }
            res.add(ans);

            curr.remove(curr.size() -1); // remove
            visited[i] = false;
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3};
//        String permutations = solution.getPermutation(7,78494);
        String permutations = solution.getPermutation(3,3);
        System.out.println(permutations);
    }
}
