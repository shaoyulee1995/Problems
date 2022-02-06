# Queue
* Time Complexity: O(MN)
* Space Complexity: O(MN)
	* N as length of matrix
	* M as length of matrix[0]
```
class Solution {
    public void setZeroes(int[][] matrix) {
        Queue<int[]> queue = new LinkedList();
        int n = matrix.length,
            m = matrix[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            updateMatrix(matrix, cell[0], cell[1]);
        }
    }
    public void updateMatrix(int[][] matrix, int row, int col){
        int n = matrix.length,
            m = matrix[0].length;
        for(int i = 0; i < m; i++){
            matrix[row][i] = 0;
        }
        for(int i = 0; i < n; i++){
            matrix[i][col] = 0;
        }
    }
}
```