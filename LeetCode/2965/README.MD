# Find Missing and Repeated Values

- Time Complexity: O(NM)
- Space Complexity: O(NM)
  - N as length of grid
  - M as length of grid[0]

```java
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] res = new int[2];
        boolean[] visited = new boolean[grid.length*grid[0].length+1];
        for(int[] row: grid){
            for(int v: row){
                if(visited[v]){
                    res[0] = v;
                }
                visited[v] = true;
            }
        }
        for(int i = 1; i < visited.length; i++){
            if(!visited[i]){
                res[1] = i;
                return res;
            }
        }
        return null;
    }
}
```
