# Lucky Numbers in a Matrix

- Time Complexity: O(NM)
- Space Complexity: O(Max(N, M))
  - N as length of matrix
  - M as length of matrix[0]

```java
class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> res = new ArrayList();
        int[] min = new int[matrix.length],
              max = new int[matrix[0].length];
        Arrays.fill(min, Integer.MAX_VALUE);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                min[i] = Math.min(min[i], matrix[i][j]);
                max[j] = Math.max(max[j], matrix[i][j]);
            }
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(min[i] == max[j]){
                    res.add(matrix[i][j]);
                    break;
                }
            }
        }
        return res;
    }
}
```
