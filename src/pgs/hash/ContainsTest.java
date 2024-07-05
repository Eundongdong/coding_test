package pgs.hash;//PGS 전화번호부
// HashSet contains 공부

import java.util.*;

public class ContainsTest {
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> hs = new HashSet<>();
        for(String phone : phone_book){
            hs.add(phone);
        }

        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++) {
                String prefix = phone.substring(0, i);
                if (hs.contains(prefix)){
                    return false;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String test = "abc";
        System.out.println(test.contains("abc"));

        String[]phone_book = new String[]{"119", "97674223", "1195524421"};
        System.out.println(solution(phone_book));
    }
}
