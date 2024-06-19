# Super Egg Drop

# Binary Search

- Time Complexity: O(KNlog(N))
- Space Complexity: O(KN)
  - K as number of eggs
  - N as number of floors

```
class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k+1][n+1];
        return superEggDrop(k, n, dp);
    }
    public int superEggDrop(int k, int n, int[][] dp){
        if(k == 1){
            return n;
        }
        if(n <= 1){
            return n;
        }

        if(dp[k][n] > 0){
            return dp[k][n];
        }
        int i = 1, j = n, res = n;
        while(i < j){
            int mid = i + (j-i)/2;
            int broken = superEggDrop(k-1, mid-1, dp);
            int unBroken = superEggDrop(k, n-mid, dp);
            res = Math.min(res, Math.max(broken, unBroken) + 1);
            if(broken == unBroken){
                break;
            }else if(broken < unBroken){
                i = mid + 1;
            }else if(broken > unBroken){
                j = mid;
            }
        }
        dp[k][n] = res;
        return res;
    }
}
```
