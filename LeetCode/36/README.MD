# Valid Sudoku

- Time Complexity: O(MN)
- Space Complexity: O(1)
  - M as length of board.length
  - N as length of board[0].length

```java
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++){
            if(!isColumnValid(board, i)){
                return false;
            }
        }
        for(int j = 0; j < board[0].length; j++){
            if(!isRowValid(board, j)){
                return false;
            }
        }
        for(int i = 0; i < board.length; i+=3){
            for(int j = 0; j < board[0].length; j+=3){
                if(!isBoxValid(board, i, j)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isBoxValid(char[][] board, int rowIndex, int columnIndex){
        HashSet<Character> seen = new HashSet();
        for(int i = rowIndex; i < rowIndex+3; i++){
            for(int j = columnIndex; j < columnIndex+3; j++){
                if(board[i][j] != '.' && !seen.add(board[i][j])){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isRowValid(char[][] board, int columnIndex){
        HashSet<Character> seen = new HashSet();
        for(int i = 0; i < board.length; i++){
            if(board[i][columnIndex] != '.' && !seen.add(board[i][columnIndex])){
                return false;
            }
        }
        return true;
    }

    private boolean isColumnValid(char[][] board, int rowIndex){
        HashSet<Character> seen = new HashSet();
        for(int j = 0; j < board[0].length; j++){
            if(board[rowIndex][j] != '.' && !seen.add(board[rowIndex][j])){
                return false;
            }
        }
        return true;
    }
}
```
