# Array
* Time Complexity: O(NM)
* Space Complexity: O(1)
	* N as length of board
	* M as length of board[0]
```
class Solution {
    public int numRookCaptures(char[][] board) {
        int x = 0, 
            y = 0,
            res = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'R'){
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int[] dir: dirs){
            for(int a = x + dir[0], b = y + dir[1]; a < 8 && a >= 0 && b < 8 && b >= 0; a += dir[0], b += dir[1]){
                if(board[a][b] == 'p'){
                    res++;
                }
                if(board[a][b] != '.'){
                    break;
                }
            }
        }
        return res;
    }
}
```