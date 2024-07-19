package boj.bfsdfs.keysnrooms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {

    static int cnt =1;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(0,rooms,visited);
//        return cnt == rooms.size();
        for(boolean b : visited){
            if(!b){
                return false;
            }
        }
        return true;
    }

    void dfs(int i, List<List<Integer>> rooms,boolean[] visited){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(i);
        visited[i] = true;
        while(!stack.isEmpty()){
            int curr = stack.pop();
            for(int j : rooms.get(curr)){
                if(!visited[j]){
                    stack.push(j);
                    visited[j] = true;
                    cnt++;
                }
            }
        }
    }

}
public class Main {
    public static void main(String[] args) {
        List<List<Integer>> rooms1 = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(3),
                new ArrayList<>()
        );
        Solution solution = new Solution();
//        System.out.println(solution.canVisitAllRooms(rooms1)); // Output: true

        // Test case 2
        List<List<Integer>> rooms2 = Arrays.asList(
                Arrays.asList(1, 3),
                Arrays.asList(3, 0, 1),
                Arrays.asList(2),
                Arrays.asList(0)
        );
//        System.out.println(solution.canVisitAllRooms(rooms2)); // Output: false

        // Test case 3
        List<List<Integer>> rooms3 = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(0),
                Arrays.asList(0),
                Arrays.asList(0)
        );
//        System.out.println(solution.canVisitAllRooms(rooms3)); // Output: true

        // Test case 4
        List<List<Integer>> rooms4 = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(1),
                Arrays.asList(0)
        );
//        System.out.println(solution.canVisitAllRooms(rooms4)); // Output: false
        // Test case 5
        List<List<Integer>> rooms5 = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        rooms5.add(new ArrayList<>(tmp));
        rooms5.add(new ArrayList<>(tmp));
        System.out.println(solution.canVisitAllRooms(rooms5)); // Output: false



    }


}