package boj.hash.teach;

import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        if(k <5){
            bw.write(0 +"\n");
            bw.flush();
            return;
        }
        String[] arr = new String[n];
        List< Set<Character>> setList = new ArrayList<>();
        List<Integer> charCountList = new ArrayList<>();// a,c,t,n,i
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            arr[i] = word.substring(4, word.length()-4);
            System.out.println(arr[i]);
            Set<Character> set = new HashSet<>();
            for(char c : arr[i].toCharArray()) {
                set.add(c);
            }
            setList.add(set);
        }

        //setList 개수 작은 순대로 오름차순 정렬
        setList.sort(Comparator.comparingInt(Set::size));

        int ans =0;

        //지금까지 글자 목록
        Set<Character> wordSet = new HashSet<>(Arrays.asList('a','c','t','n','i'));
        k -=5;

        for(int i =0; i<setList.size(); i++){
            Set<Character> nowSet = setList.get(i);
            if(k >0){
                //단어목록에 있는 것들 삭제
                for(char c : wordSet){
                    if(nowSet.contains(c)){
                        nowSet.remove(c);
                    }
                }
                if(nowSet.isEmpty()){
                    ans++;
                }else if( k - wordSet.size() >= 0){
                    k -= wordSet.size();
                    wordSet.addAll(setList.get(i));
                    setList.remove(i);
                    ans++;
                }

            }else{
                break;
            }
        }
        bw.write(ans +"\n");
        bw.flush();





    }
}
