# Number Of Corner Rectangles

- Time Complexity: O(NM<sup>2</sup>)
- Space Complexity: O(NM)
  - N as length of grid
  - M as length of grid[0]

```java
class Solution {
    public int countCornerRectangles(int[][] grid) {
        int res = 0;
        HashMap<List<Integer>, Integer> map = new HashMap();
        for(int[] row: grid){
            for(int c1 = 0; c1+1 < grid[0].length; c1++){
                if(row[c1] == 1){
                    for(int c2 = c1+1; c2 < grid[0].length; c2++){
                        if(row[c2] == 1){
                            List<Integer> pair =List.of(c1, c2);
                            res += map.getOrDefault(pair, 0);
                            map.put(pair, map.getOrDefault(pair, 0)+1);
                        }
                    }
                }
            }
        }
        return res;
    }
}
```

- Time Complexity: O(N<sup>2</sup>M)
- Space Complexity: O(1)
  - N as length of grid
  - M as length of grid[0]

```java
class Solution {
    public int countCornerRectangles(int[][] grid) {
        int res = 0;
        for(int i = 0; i+1 < grid.length; i++){
            for(int j = i+1; j < grid.length; j++){
                int columnOnes = 0;
                for(int k = 0; k < grid[0].length; k++){
                    if((grid[i][k] & grid[j][k]) == 1){
                        columnOnes++;
                    }
                }
                res += columnOnes*(columnOnes-1)/2;
            }
        }
        return res;
    }
}
```

- Time Complexity: O(N<sup>2</sup>M<sup>2</sup>)
- Space Complexity: O(1)
  - N as length of grid
  - M as length of grid[0]

```java
class Solution {

    public int countCornerRectangles(int[][] grid) {
        int res = 0;
        for(int i = 0; i+1 < grid.length; i++){
            for(int j = 0; j+1 < grid[0].length; j++){
                if(grid[i][j] == 0){
                    continue;
                }
                for(int p = i+1; p < grid.length; p++){
                    if(grid[p][j] == 0){
                        continue;
                    }
                    for(int q = j+1; q < grid[0].length; q++){
                        res += grid[i][q] & grid[p][q];
                    }
                }
            }
        }
        return res;
    }
}
```

- Time Complexity: O(N<sup>2</sup>M)
- Space Complexity: O(N<sup>2</sup>)
  - N as length of grid
  - M as length of grid[0]

```java
class Solution {

    public int countCornerRectangles(int[][] grid) {
        int[][] dp = new int[grid[0].length][grid[0].length];
        int res = 0;
        for(int j = 0; j < grid[0].length; j++){
            for(int i = 0; i < grid.length; i++){
                if(grid[i][j] == 0){
                    continue;
                }
                for(int k = j+1; k < grid[0].length; k++){
                    if(grid[i][k] == 0){
                        continue;
                    }
                    res += dp[j][k];
                    dp[j][k]++;
                }
            }
        }
        return res;
    }
}
```
