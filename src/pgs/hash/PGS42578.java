package pgs.hash;//PGS 의상
//해시맵
import java.util.*;

class PGS42578 {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String,Integer> closet = new HashMap<>();
        for(int i = 0;i < clothes.length;i++){
            String type =clothes[i][1];
            closet.put(type, closet.getOrDefault(type,0) +1);
        }
        for(String type : closet.keySet()){
            answer *= closet.get(type) +1;
        }
        
        return answer -1;
    }
}