# Find Winner on a Tic Tac Toe Game

```
class Solution {
    public String tictactoe(int[][] moves) {
        int[] a = new int[8],
              b = new int[8];
        for(int i = 0; i < moves.length; i++){
            int[] p = (i%2==0)? a: b;
            int r = moves[i][0],
                c = moves[i][1];
            p[r]++;
            p[c+3]++;
            if(r == c){
                p[6]++;
            }
            if(r == 2-c){
                p[7]++;
            }
        }
        for(int i = 0; i < 8; i++){
            if(a[i] == 3){
                return "A";
            }
            if(b[i] == 3){
                return "B";
            }
        }
        return moves.length == 9? "Draw": "Pending";
    }
}
```
