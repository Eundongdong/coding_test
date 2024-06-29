//PGS 폰켓몬
//해시맵 공부
import java.util.*;
public class Pokemon {
    static class Solution {
        public int solution(int[] nums) {

            HashMap<Integer,Integer> p = new HashMap<>();

            for (int num : nums){
                //이미 등록되어있다면
                if(p.containsKey(num)){
                    int oldValue= p.get(num);
                    p.replace(num,oldValue+1);
                }else{
                    p.put(num,1);
                }
            }
            int n = nums.length;
            int answer = 0;
            if(n/2 <=p.size()){
                answer = n/2;
            }else{
                answer = p.size();
            }

            return answer;
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3,1,2,3};
        Solution s = new Solution();
        System.out.println(s.solution(nums));

        
    }
}
