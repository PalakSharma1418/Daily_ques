// Last updated: 8/6/2025, 4:50:21 PM
class Solution {
    public boolean exist(char[][] board, String word) {
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(word.charAt(0) == board[i][j]){
                    boolean result = dfs(board, i, j, word, 0);
                    if(result){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int row, int col, String word, int index){

        if(index == word.length()){
            return true;
        }
        if(row < 0 || col < 0 || row >= board.length || col >= board[row].length || word.charAt(index) != board[row][col] || board[row][col] == '@'){
            return false;
        }
        
        char c = board[row][col];
        board[row][col] = '@';

        boolean result = dfs(board, row - 1, col, word, index + 1)
        || dfs(board, row + 1, col, word, index + 1)
        || dfs(board, row, col - 1, word, index + 1)
        || dfs(board, row, col + 1, word, index + 1);

        board[row][col] = c;
        return result;
    }
}