# Matrix
* Time Complexity: O(NM)
* Space Complexity: O(NM)
	* N as length of matrix
    * M as length of matrix[0]
```
class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int[] cols = new int[matrix[0].length];
        List<int[]> reset = new ArrayList();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == -1){
                    reset.add(new int[]{i, j});
                }else{
                    cols[j] = Math.max(cols[j], matrix[i][j]);
                }
            }
        }
        for(int i = 0; i < reset.size(); i++){
            int[] cur = reset.get(i);
            matrix[cur[0]][cur[1]] = cols[cur[1]];
        }
        return matrix;
    }
}
```