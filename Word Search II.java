/*
   Given an m x n board of characters and a list of strings words, return all words on the board.

   Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
   
   Example 1:
   Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
   Output: ["eat","oath"]

   Example 2:   
   Input: board = [["a","b"],["c","d"]], words = ["abcb"]
   Output: []
*/


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Word_Search_II {
    public static void search(char[][] board, int i, int j, int m, int n, HashSet<String> set, ArrayList<String> ans, StringBuilder sb){
        if(set.contains(sb.toString())){
            if(!ans.contains(sb.toString())){
                ans.add(sb.toString());
            } 
        }
        if(i < 0 || j < 0 || i == m || j == n || board[i][j] =='#') return;
        char ch = board[i][j];
        sb.append(board[i][j]);
        board[i][j] = '#';
        search(board, i + 1, j, m, n, set, ans, sb);
        search(board, i - 1, j, m, n, set, ans, sb);
        search(board, i, j + 1, m, n, set, ans, sb);
        search(board, i, j - 1, m, n, set, ans, sb);
        sb.deleteCharAt(sb.length() - 1);
        board[i][j] = ch;
    }
    public static List<String> findWords(char[][] board, String[] words) {
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < words.length; i++){
            set.add(words[i]);
        }
        ArrayList<String> ans = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            char ch = words[i].charAt(0);
            for(int j = 0; j < board.length; j++){
                for(int k = 0; k < board[j].length; k++){
                    if(board[j][k] == ch){
                        search(board, j, k, board.length, board[0].length, set, ans, new StringBuilder());
                    }
                }
            }
        }        
        return ans;
    }
    public static void main(String[] args) {
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oa", "oaa"};
        System.out.println(findWords(board, words));
    }
}
