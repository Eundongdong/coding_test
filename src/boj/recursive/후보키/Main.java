package boj.recursive.후보키;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Solution {
    static HashMap<List<Integer>,Boolean> map = new HashMap<>();
    static List<List<Integer>> onlyKeys = new ArrayList<>();
    public int solution(String[][] relation) {
        List<List<Integer>> allKey = new ArrayList<>();
        int total = relation[0].length;
        int cadinality = relation.length;
        recur(0,new ArrayList<>(), total,allKey);


        //유일성 검증
        for(int i =0; i<allKey.size(); i++){
            insertValue(allKey.get(i),relation,cadinality);
        }
        int cnt=0;
        //최소성 검증
        // key 하나당 만들 수 있는 모든 조합이(본인제외) 모두 유일성 false라면 최소성을 만족하는 키
        for(int i = 0; i<onlyKeys.size(); i++){
            boolean flag= false;
            List<List<Integer>> tmpKeys = new ArrayList<>();
            int tmpTotal = onlyKeys.get(i).size();
            // key로 만드는 모든 조합
            recur(0,new ArrayList<>(), tmpTotal,tmpKeys,onlyKeys.get(i));
            for (List<Integer> tmp : tmpKeys) {
                // 쪼갠 조합으로 유일성을 만족하고, 자기자신이 아니라면
                if (map.get(tmp) && tmp.size() != tmpTotal) {
                    //삭제
                    cnt++;
                    break;
                }
            }
        }
        return onlyKeys.size() - cnt;
    }

    void insertValue(List<Integer> keys, String[][]relation, int total){
        //keys에 있는 index를 토대로 relation에서 값을 찾아와 HashSet에 저장하기

        HashSet<List<String>> set = new HashSet<>();
        for (int i = 0; i < total; i++) {
            List<String> tmp = new ArrayList<>();
            //keys에 있는 key들을 순회하며
            // 릴레이션에서 key에 해당하는 값을 넣어준다.
            for (int j = 0; j < keys.size(); j++) {
                tmp.add(relation[i][keys.get(j)]);
            }
            //tmp 값을 HashSet에 넣어준다
            set.add(new ArrayList<>(tmp));
        }
        if(set.size() == total){
            map.put(new ArrayList<>(keys), true);
            onlyKeys.add(new ArrayList<>(keys));
        }else{
            map.put(new ArrayList<>(keys), false);
        }

    }

    void recur(int idx, List<Integer> curr,int total,List<List<Integer>> allKey) {
        if(idx == total) {
            if(!curr.isEmpty())
                allKey.add(new ArrayList<>(curr));
            return;
        }
        recur(idx +1,curr,total,allKey);
        curr.add(idx);
        recur(idx +1,curr,total,allKey);
        curr.remove(curr.size()-1);
    }
    void recur(int idx, List<Integer> curr, int total, List<List<Integer>> allKey, List<Integer> keys) {
        if(idx == total) {
            if(!curr.isEmpty())
                allKey.add(new ArrayList<>(curr));
            return;
        }
        recur(idx +1,curr,total,allKey,keys);
        curr.add(keys.get(idx));
        recur(idx +1,curr,total,allKey,keys);
        curr.remove(curr.size()-1);
    }

}