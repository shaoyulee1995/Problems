# Matrix Similarity After Cyclic Shifts

- Time Complexity: O(NM)
- Space Complexity: O(1)
  - N as length of mat
    - M as length[0] of mat

```
class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] != mat[i][(j+k)%mat[0].length]){
                    return false;
                }
            }
        }
        return true;
    }
}
```
