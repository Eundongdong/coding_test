package boj.recursive.Permutation;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        boolean[] visited = new boolean[length];
        backtrack(new ArrayList<>(),nums,visited, res);
        return res;
    }

    // 순열을 만들어서 result에 추가하는 함수
    void backtrack(List<Integer> curr, int nums[],boolean[] visited, List<List<Integer>>res ){
        //base case
        if(curr.size() == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }


        //recursive call
        for(int i =0;i<nums.length;i++){
            if(visited[i]) continue;


            curr.add(nums[i]); // add
            visited[i] = true;

            backtrack(curr,nums,visited,res);
            curr.remove(curr.size() -1); // remove
            visited[i] = false;
        }
    }

}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3};
        List<List<Integer>> permutations = solution.permute(nums);
        for(List<Integer> permutation : permutations){
            System.out.println(permutation);
        }
    }
}
