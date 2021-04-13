class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length,
            n = mat[0].length;
        
        //update row = 0;
        for(int row = 0; row < m; row++){
            sort(mat, row, 0, m, n);
        }
        
        //update col = 0;
        for(int col = 0; col < n; col++){
            sort(mat, 0, col, m, n);
        }
        return mat;
    }
    
    public void sort(int[][] mat, int row, int col, int m, int n){
        int[] cnt = new int[101];
        
        int r = row, c = col;
        
        while(r < m && c < n){
            cnt[mat[r][c]]++;
            r++; c++;
        }
        
        r = row; c = col;
        
        for(int i = 1; i < 101; i++){
            if(cnt[i] == 0){
                continue;
            }
            int freq = cnt[i];
            while(freq != 0){
                mat[r][c] = i; 
                r++; c++;
                freq--;
            }
            
        }
    }
}