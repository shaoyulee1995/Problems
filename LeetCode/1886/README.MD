# Determine Whether Matrix Can Be Obtained By Rotation

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(N<sup>2</sup>)
  - N as length of mat

```java
class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int srcOnes = getOnes(mat),
            targetOnes = getOnes(target);
        if(srcOnes != targetOnes){
            return false;
        }
        HashSet<String> set = new HashSet();
        String targetModel = toStringByMatrix(target);
        while(!set.contains(toStringByMatrix(mat))){
            set.add(toStringByMatrix(mat));
            rotate(mat);
            if(toStringByMatrix(mat).equals(targetModel)){
                return true;
            }  
        }
        return false;
    }

    public void swapCell(int[][] mat, int i, int j){
        int temp = mat[i][j];
        mat[i][j] = mat[j][i];
        mat[j][i] = temp;
    }

    public void swapRow(int[][] mat, int a, int b){
        int[] temp = mat[a];
        mat[a] = mat[b];
        mat[b] = temp; 
    }
    public void rotate(int[][] mat){
        for(int i = 0, j = mat.length-1; i < j; i++, j--){
            swapRow(mat, i, j);
        }
        for(int r = 0; r < mat.length; r++){  
            for(int c = r+1; c < mat.length; c++){
                swapCell(mat, r, c);
            }
        }
    }

    public String toStringByMatrix(int[][] matrix){
        StringBuilder sb = new StringBuilder();
        for(int[] row: matrix){
            for(int val: row){
                sb.append(val).append(" ");
            }
        }
        return sb.toString();
    }

    public int getOnes(int[][] matrix){
        int res = 0;
        for(int[] row: matrix){
            for(int val: row){
                res += val;
            }
        }
        return res;
    }
}
```

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(N<sup>2</sup>)
  - N as length of mat

```java
class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int matSize = mat.length;
        for(int i = 0; i < 4; i++){
            if(compareMatrix(mat, target, matSize)){
                return true;
            }
            mat = rotateMatrix(mat, matSize);
        }
        return false;
    }

    private boolean compareMatrix(int[][] src, int[][] dest, int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(src[i][j] != dest[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    private int[][] rotateMatrix(int[][] mat, int n){
        int[][] res = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                res[j][n-1-i] = mat[i][j];
            }
        }
        return res;
    }
}
```