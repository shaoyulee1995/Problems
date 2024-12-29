# Row With Maximum Ones

- Time Complexity: O(NM)
- Space Complexity: O(1)
  - N is the number of rows in the grid
  - M is the number of columns in the grid

```java
class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] res = new int[2];
        for(int i = 0; i < mat.length; i++){
            int ones = (int)Arrays.stream(mat[i]).filter(x -> x == 1).count();
            if(ones > res[1]){
                res[0] = i;
                res[1] = ones;
            }
        }
        return res;
    }
}
```
