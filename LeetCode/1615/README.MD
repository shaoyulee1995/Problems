# Maximal Network Rank

# Graph

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(N<sup>2</sup>)
  - N as n

```java
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] connect = new boolean[n][n];
        int[] res = new int[n];
        for(int[] road: roads){
            res[road[0]]++;
            res[road[1]]++;
            connect[road[0]][road[1]] = true;
            connect[road[1]][road[0]] = true;
        }
        int ans = 0;
        for(int i = 0; i+1< n; i++){
            for(int j = i+1; j < n; j++){
                ans = Math.max(ans, res[i] + res[j] - ((connect[i][j])? 1: 0));
            }
        }
        return ans;
    }
}
```

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(N<sup>2</sup>)
  - N as n

```java
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        HashSet<Integer>[] rows = new HashSet[n];
        for(int i = 0; i < n; i++){
            rows[i] = new HashSet();
        }
        for(int[] road: roads){
            rows[road[0]].add(road[1]);
            rows[road[1]].add(road[0]);
        }
        int res = 0;
        for(int i = 0; i + 1< n; i++){
            for(int j = i + 1; j < n; j++){
                res = Math.max(res, rows[i].size() + rows[j].size() - (rows[i].contains(j)?1:0));
            }
        }
        return res;
    }
}
```
