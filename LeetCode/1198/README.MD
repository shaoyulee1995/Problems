# Find Smallest Common Element in All Rows

- Time Complexity: O(MN)
- Space Complexity: O(10001)
  - M as length of mat
  - N as length of mat[0]

```java
class Solution {
    public int smallestCommonElement(int[][] mat) {
        int[] freq = new int[10001];
        for(int[] m: mat){
            for(int val: m){
                freq[val]++;
                if(freq[val] == mat.length){
                    return val;
                }
            }
        }
        return -1;
    }
}
```
