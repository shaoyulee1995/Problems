# Maximum Length of Repeated Subarray

# 2DP

- Time Complexity: O(NM)
- Space Complexity: O(NM)
  - N as length of nums1
  - N as length of nums2

```
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        int res = 0;
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    dp[i+1][j+1] = dp[i][j] + 1;
                    res = Math.max(res, dp[i+1][j+1]);
                }
            }
        }
        return res;
    }
}
```

# 1DP

- Time Complexity: O(NM)
- Space Complexity: O(N)
  - N as length of nums1
  - N as length of nums2

```
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int[] dp = new int[nums1.length+1];
        int res = 0;
        for(int i = 0; i < nums1.length; i++){
            for(int j = nums2.length-1; j >= 0; j--){
                if(nums1[i] == nums2[j]){
                    dp[j+1] = dp[j] + 1;
                }else{
                    dp[j+1] = 0;
                }
                res = Math.max(res, dp[j+1]);
            }
        }
        return res;
    }
}
```
