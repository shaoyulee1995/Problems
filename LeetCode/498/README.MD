# Diagonal Traverse
# Matrix
* Time Complexity: O(NM)
* Space Complexity: O(NM)
	* M as length of mat
	* N as length of mat[0]
```
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int[] res = new int[mat.length*mat[0].length];
        int row = 0,
            col = 0;
        for(int i = 0; i < res.length; i++){
            res[i] = mat[row][col];
            if((row+col)%2 == 0){
                if(col == mat[0].length-1){
                    row++;
                }else if(row == 0){
                    col++;
                }else{
                    row--;
                    col++;
                }
            }else{
                if(row == mat.length-1){
                    col++;
                }else if(col == 0){
                    row++;
                }else{
                    row++;
                    col--;
                }
            }
        }
        return res;
    }
}
```