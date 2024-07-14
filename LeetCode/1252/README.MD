# Cells with Odd Values in a Matrix

# Arrays

- Time Complexity: O(L)
- Space Complexity: O(MN)
  - L is the length of indices array

```java
class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];
        int cntRow = 0, cntCol = 0;
        for(int[] i: indices){
            rows[i[0]] ^= true;
            cols[i[1]] ^= true;
            cntRow += (rows[i[0]])?1:-1;
            cntCol += (cols[i[1]])?1:-1;
        }
        return (n-cntCol)*cntRow + (m-cntRow)*cntCol;
    }
}
```
