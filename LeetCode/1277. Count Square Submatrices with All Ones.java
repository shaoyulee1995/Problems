class Solution {
    public int countSquares(int[][] matrix) {
        int result = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    continue;
                }
                if(i == 0 || j == 0){
                    result++;
                    continue;
                }
                
                int min = Math.min(matrix[i][j-1],
                          Math.min(matrix[i-1][j], matrix[i-1][j-1]));
                matrix[i][j] += min;
                result += matrix[i][j];
            }
        }
        return result;
    }
}