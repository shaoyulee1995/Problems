# Special Positions in a Binary Matrix
# BF
* Time Complexity: O(NM*max(N,M))
* Space Complexity: O(1)
	* N as length of mat
	* M as length of mat[0]
```
class Solution {
    public int numSpecial(int[][] mat) {
        int res = 0;
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0){
                    continue;
                }
                if(horizontalAndVertical(mat, i, j)){
                    res++;
                }
            }
        }
        return res;
    }


    public boolean horizontalAndVertical(int[][] mat, int x, int y){
        for(int i = 0; i < mat.length; i++){
            if(i != x){
                if(mat[i][y] == 1){
                    return false;
                }
            }
        }
        for(int j = 0; j < mat[0].length; j++){
            if(j != y){
                if(mat[x][j] == 1){
                    return false;
                }
            }
        }
        return true;
    }
}
```
# Counting Array
* Time Complexity: O(NM)
* Space Complexity: O(1)
	* N as length of mat
	* M as length of mat[0]
```
class Solution {
    public int numSpecial(int[][] mat) {
        int[] rows = new int[mat.length],
              cols = new int[mat[0].length];
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 1){
                    rows[i]++;
                    cols[j]++;
                }
            }
        }
        int res = 0;
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 1){
                    if(rows[i] == 1 && cols[j] == 1){
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
```