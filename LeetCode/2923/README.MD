# Find Champion I

- Time Complexity: O(M)
- Space Complexity: O(1)
    - M as length of grid[0]
```java
class Solution {
    public int findChampion(int[][] grid) {
        int winner = 0;
        for(int opponent = 1; opponent<grid[0].length; opponent++){
            if(opponent==winner){
                continue;
            }
            if(grid[winner][opponent]==0){
                winner = opponent;
            }
        }
        return winner;
    }
}
```

- Time Complexity: O(NM)
- Space Complexity: O(1)
    - N as length of grid
    - M as length of grid[0]
```java
class Solution {
    public int findChampion(int[][] grid) {
        int res = 0,
            mostOnes = 0;
        for(int i = 0; i < grid.length; i++){
            int[] row = grid[i];
            int ones = 0;
            for(int r: row){
                ones += r;
            }
            if(ones > mostOnes){
                res = i;
                mostOnes = ones;
            }
        }
        return res;
    }
}
```