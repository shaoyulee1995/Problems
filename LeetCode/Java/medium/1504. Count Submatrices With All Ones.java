class Solution {
    public int numSubmat(int[][] mat) {
        
        for(int i = 0; i < mat[0].length; i++){
            int colNum = 0;
            for(int j = 0; j < mat.length; j++){
                if(mat[j][i] == 0){
                    colNum = 0;
                }else{
                    colNum++;
                }
                mat[j][i] = colNum;
            }
        }
        int total = 0;
        
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                int min = Integer.MAX_VALUE, k = j;
                while(k>=0 && mat[i][k] != 0){
                    min = Math.min(min,mat[i][k]);
                    total+=min;
                    k--;
                }
            }
        }
        return total;
    }
}