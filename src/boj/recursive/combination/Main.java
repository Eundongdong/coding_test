package boj.recursive.combination;


import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, n, k, res, new ArrayList<>());
        return res;
    }

    void backtrack(int idx,int n, int k, List<List<Integer>> res, List<Integer> curr) {
        if (k == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=idx; i<=n; i++) {
            curr.add(i);
            backtrack(i+1, n, k-1, res,curr);
            curr.remove(curr.size()-1);

        }
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combine(4, 3));
    }

    }
