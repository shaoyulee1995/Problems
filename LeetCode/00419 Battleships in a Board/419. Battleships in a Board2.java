class Solution {
    public int countBattleships(char[][] board) {
        int cnt = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                //Battleships can only be placed horizontally or vertically on board 
                if(board[i][j] =='.'){
                    continue;
                }
                //check vertically
                if(i>0 && board[i-1][j] =='X'){
                    continue;
                }
                //check horizontally
                if(j>0 && board[i][j-1] =='X'){
                    continue;
                }
                cnt++;
            }
        }
        return cnt;
    }
}