class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        
        int[] row = new int[m],
              col = new int[n];
        
        for(int[] x: indices){
            row[x[0]]++;
            col[x[1]]++;
        }
        int cnt = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if((row[i] + col[j])% 2 != 0){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}