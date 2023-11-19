# Matrix
* Time Complexity: O(NM)
* Space Complexity: O(RC)
	* N as length of mat
	* M as length of mat[0]
	* R as r
	* C as c
```
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(r*c != mat.length * mat[0].length || mat.length == 0){
            return mat;
        }
        int[][] res = new int[r][c];
        int a = 0,
            b = 0;
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){                
                res[a][b++] = mat[i][j];
                if(b == c){
                    a++;
                    b = 0;
                }
            }
        }    
        return res;
    }
}

```