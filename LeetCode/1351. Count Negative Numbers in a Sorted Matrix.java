class Solution {
    public int countNegatives(int[][] grid) {
        int cnt = 0;
        for(int[] row: grid){
            for(int i = 0; i < row.length; i++){
                if(row[i] < 0){
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}