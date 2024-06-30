import java.util.*;

public class Permutation {

    public static void main(String[] args) {

        int arr[]={1,2,3};
        int output[]=new int[arr.length];
        boolean visited[]=new boolean[arr.length];

        permutation(arr,output,visited,0,2);
//        for(int i=0;i<arr.length;i++){
//            permutation(arr,output,visited,0,i+1);
//        }
        System.out.println("test");

    }

    /**
     * nPr 순열 조합 모두 출력
     * @param arr : 원본 배열 (여기서 순열 만듦)
     * @param output : 출력할 배열
     * @param visited : 방문여부체크, dfs
     * @param depth : 현재 탐색하고있는 인덱스
     * @param r : 뽑고자 하는 개수 nPr에서 r
     */
    public static void permutation(int arr[], int output[], boolean visited[], int depth, int r){

        if(depth==r){
            for(int i=0;i<r;i++){
                System.out.print(output[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=0;i<arr.length;i++){
            if(!visited[i]){
                visited[i]=true;
                output[depth]=arr[i];
                permutation(arr,output,visited,depth+1,r);
                visited[i]=false;
            }
        }
    }
}
