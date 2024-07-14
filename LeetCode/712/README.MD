# Minimum ASCII Delete Sum for Two Strings

# Memorizied Recursion

- Time Complexity: O(N\*M)
- Space Complexity: O(N\*M)
  - N is the length of s1
  - M is the length of s2

```java
class Solution{
    int[][] memo;
    public int minimumDeleteSum(String s1, String s2) {
        memo = new int[s1.length()][s2.length()];
        for(int[] row: memo){
            Arrays.fill(row, -1);
        }
        return minimumDeleteSum(s1, 0, s2, 0);
    }

    public int minimumDeleteSum(String s1, int p1, String s2, int p2) {
        int res = 0;
        if(s1.length() == p1){
            for(; p2 < s2.length(); p2++){
                res += s2.charAt(p2);
            }
            return res;
        }
        if(s2.length() == p2){
            for(; p1 < s1.length(); p1++){
                res += s1.charAt(p1);
            }
            return res;
        }
        if(memo[p1][p2] != -1){
            return memo[p1][p2];
        }

        if(s1.charAt(p1) == s2.charAt(p2)){
            memo[p1][p2] = minimumDeleteSum(s1, p1 + 1, s2, p2 + 1);
        }else{
            memo[p1][p2] = Math.min(s1.charAt(p1) + minimumDeleteSum(s1, p1 + 1, s2, p2),
                                    s2.charAt(p2) + minimumDeleteSum(s1, p1, s2, p2 + 1));
        }
        return memo[p1][p2];
    }
}
```
