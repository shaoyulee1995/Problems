# Jump Game VI

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```java
class Solution {
    public int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        ArrayDeque<Integer> deque = new ArrayDeque();
        deque.offerLast(0);
        for(int i = 1; i < nums.length; i++){
            while(!deque.isEmpty() && i - deque.peekFirst() > k){
                deque.pollFirst();
            }
            dp[i] = dp[deque.peekFirst()] + nums[i];
            while(!deque.isEmpty() && dp[i] >= dp[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        return dp[nums.length-1];
    }
}
```
