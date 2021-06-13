class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length;i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == word.charAt(0)
                   && dfs(board,i,j,word,0)){
                  return true;  
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, int i, int j, String word, int cnt){
        if(cnt == word.length()){
            return true;
        }
        if(i < 0 || i >= board.length){
            return false;
        }
        if(j < 0 || j >= board[i].length){
            return false;
        }
        if(board[i][j] != word.charAt(cnt)){
            return false;
        }
        
        char temp = board[i][j];
        board[i][j] = ' ';
        boolean found = dfs(board, i+1, j, word, cnt+1)||
                        dfs(board, i-1, j, word, cnt+1)||
                        dfs(board, i, j+1, word, cnt+1)||
                        dfs(board, i, j-1, word, cnt+1);
        
        board[i][j] = temp;
        return found;
    }
}