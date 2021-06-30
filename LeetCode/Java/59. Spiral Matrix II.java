class Solution {
    public int[][] generateMatrix(int n) {
        int rowStart = 0, rowEnd = n - 1,
            colStart = 0, colEnd = n - 1;
        int val = 1;
        int[][] mat = new int[n][n];
        
        while(val <= n*n){
            for(int i = colStart; i <= colEnd; i++){
                mat[rowStart][i] = val++;
            }
            rowStart++;
            for(int i = rowStart; i <= rowEnd; i++){
                mat[i][colEnd] = val++;
            }
            colEnd--;
            for(int i = colEnd; i >= colStart; i--){
                mat[rowEnd][i] = val++;
            }
            rowEnd--;
            for(int i = rowEnd; i >=rowStart ; i--){
                mat[i][colStart] = val++;
            }
            colStart++;
        }
        return mat;
    }
}