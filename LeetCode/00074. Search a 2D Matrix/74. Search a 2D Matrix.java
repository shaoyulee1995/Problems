class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, 
            cols = matrix[0].length;
        int i = 0, j = rows * cols - 1;
        while(i <= j){
            int m = i + (j-i)/2,
                value = matrix[m/cols][m%cols];
            if(value == target){
                return true;
            }
            if(value < target){
                i = m + 1;
            }else{
                j = m - 1;
            }
        }
        return false;
    }
}