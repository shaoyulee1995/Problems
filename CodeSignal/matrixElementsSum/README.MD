* Time Complexity: O(N^2)
* Space Complexity: O(1)
```
int matrixElementsSum(int[][] matrix) {
    int ans = 0;
    for(int col = 0; col < matrix[0].length; col++){
        for(int row = 0; row < matrix.length; row++){
            if(matrix[row][col] == 0){
                break;
            }
            ans += matrix[row][col];
        }
    }
    return ans;
}
```