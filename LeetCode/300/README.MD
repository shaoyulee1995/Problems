# Longest Increasing Subsequence

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(N)
    - N as length of nums

```java
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
```

- Time Complexity: O(NlogN)
- Space Complexity: O(N)
    - N as length of nums

```java
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] top = new int[nums.length];
        int piles = 0;
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            int left = 0,
                right = piles;
            while(left < right){
                int mid = left + (right - left)/2;
                if(top[mid] > num){
                    right = mid;
                }else if(top[mid] < num){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
            if(left == piles){
                piles++;
            }
            top[left] = num;
        }
        return piles;
    }
}
```
