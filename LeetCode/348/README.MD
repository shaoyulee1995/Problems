# Design Tic-Tac-Toe

```java
Your TicTacToe object will be instantiated and called as such:
TicTacToe obj = new TicTacToe(n);
int param_1 = obj.move(row,col,player);
```

- Time Complexity: O(1)
- Space Complexity: O(N)
  - N as size of the board

```java
class TicTacToe {

    int[] rows, cols;
    int diagonal, antiDiagonal, n;
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        this.n = n;
    }
    
    public int move(int row, int col, int player) {
        int user = (player == 1)? 1: -1;
        rows[row] += user;
        cols[col] += user;
        if(row == col){
            diagonal += user;
        }
        if(col == (cols.length - row - 1)){
            antiDiagonal += user;
        }
        if(Math.abs(rows[row]) == n || 
           Math.abs(cols[col]) == n || 
           Math.abs(diagonal) == n || 
           Math.abs(antiDiagonal) == n){
            return player;
        }
        return 0;
    }
}
```