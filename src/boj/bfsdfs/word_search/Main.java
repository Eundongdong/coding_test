package boj.bfsdfs.word_search;
class Solution {

    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    boolean answer = false;
    public boolean exist(char[][] board, String word) {
        int xLength = board[0].length;
        int yLength = board.length;
        if(xLength*yLength <word.length()){
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i<board.length;i++){
            for(int j =0; j<board[0].length;j++){
            backtrack(board,word,0,j,i,visited);
            }
        }
        return answer;

    }
    //idx는 현재 만든 문자열 개수
    //x,y는 현재 위치
    //visited : 보드 방문 관리
    void backtrack(char[][] board, String word, int idx, int x, int y, boolean[][] visited) {
        //맵 안에 있고, 단어가 맞다면 이어가기
        if (0 <= x && x < board[0].length && 0 <= y && y < board.length) {
            if (idx < word.length()  &&!visited[y][x] && word.charAt(idx) == board[y][x] ){
                //idx가 word.length()일 때 마지막
                if ((idx + 1) == word.length()) {
                    answer = true;
                    return;
                }
                visited[y][x] = true;
                idx++;
                //4방향 이동
                for (int i = 0; i < 4; i++) {
                    int nx = x + dirs[i][0];
                    int ny = y + dirs[i][1];

                    //재귀

                    backtrack(board, word, idx, nx, ny, visited);
                }
                visited[y][x] = false;
            }else{
                //방향바꾸기
                return;
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABC";
        Solution solution = new Solution();
        if(solution.exist(board,word))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
