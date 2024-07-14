# Freedom Trail

# Memorization Recursion | DP

- Time Complexity: O(NM)
- Space Complexity: O(NM)
  - n = ring.length()
  - m = key.length()

```java
class Solution{
    Map<Character, Set<Integer>> map;
    int[][] dp;
    public int findRotateSteps(String ring, String key) {
        int n = ring.length(),
            m = key.length();
        map = new HashMap();
        for(int i = 0; i < n; i++){
            char c = ring.charAt(i);
            map.putIfAbsent(c, new HashSet());
            map.get(c).add(i);
        }
        dp = new int[n][m];
        for(int[] d: dp){
            Arrays.fill(d, -1);
        }
        return findRotateSteps(ring, 0, key, 0) + m;
    }
    public int findRotateSteps(String ring, int x, String key, int y){
        if(y == key.length()){
            return 0;
        }
        if(dp[x][y] != -1){
            return dp[x][y];
        }
        int min = Integer.MAX_VALUE;
        for(int k: map.get(key.charAt(y))){
            int diff = Math.abs(k-x);
            int step = Math.min(diff, ring.length() - diff);
            min = Math.min(min, step + findRotateSteps(ring, k, key, y+1));
        }
        dp[x][y] = min;
        return dp[x][y];
    }
}
```
