class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        
        int[][] output = new int[rowSum.length][colSum.length];
        
        for(int i = 0; i < rowSum.length; i++){
            for(int j = 0; j < colSum.length; j++){
                output[i][j] = Math.min(rowSum[i],colSum[j]);
                rowSum[i] -= output[i][j];
                colSum[j] -= output[i][j];
            }
        }
        return output;
    }
}