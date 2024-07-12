package boj.recursive.candidatekey;

import java.util.*;

class Solution {
    List<List<Integer>> arr = new ArrayList<>();
    public int solution(String[][] relation) {
        int answer = 0;
        int column = relation[0].length;
        int[] columnArr = new int[column];
        for(int i = 0; i< column;i++){
            columnArr[i] = i+1;
        }

        combi(0,columnArr,new ArrayList<>(),new boolean[column]);
        //for문을 순회하며 후보키가 되는지 확인
        for(List<Integer> list : arr){

        }
        return answer;

    }

    boolean isCandidate(List<Integer> list, String[][] relation){
        List<HashMap> come = new ArrayList<>();
        for(int i =0; i<relation.length;i++){
           //
        }

        return true;
    }


    void combi(int idx, int[] num, ArrayList<Integer> curr, boolean[] visited) {
        for (int i = idx; i < num.length; i++) {
            idx++;
            if (visited[i]) continue;
            visited[i] = true;
            curr.add(num[i]);
            combi(idx,num, curr, visited);

            //값 넣기
            arr.add(new ArrayList<>(curr));
            visited[i] = false;
            curr.remove(curr.size() - 1);

        }
    }



}

public class Main {
    public static void main(String[] args) {
    String[][] relation = new String[][]{{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
    Solution solution = new Solution();
    System.out.println(solution.solution(relation));
}

    }

