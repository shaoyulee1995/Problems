# Search a 2D Matrix

- Time Complexity: O(MN)
- Space Complexity: O(1)
  - M as length of matrix
    - N as length of matrix[0]

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0,
            j = matrix.length*matrix[0].length-1;
        while(i <= j){
            int k = i + (j-i)/2,
                val = matrix[k/matrix[0].length][k%matrix[0].length];
            if(val == target){
                return true;
            }
            if(val < target){
                i = k+1;
            }else{
                j = k-1;
            }
        }
        return false;
    }
}
```

- Time Complexity: O(MN)
- Space Complexity: O(1)
  - M as length of matrix
    - N as length of matrix[0]

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length,
            cols = matrix[0].length,
            i = 0,
            j = rows*cols-1;
        while(i < j){
            int k = i + (j-i)/2,
                current = matrix[k/cols][k%cols];
            if(current == target){
                return true;
            }
            if(current < target){
                i = k+1;
            }else{
                j = k;
            }
        }
        return matrix[i/cols][i%cols] == target;
    }
}
```