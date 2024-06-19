# Shortest Subarray with Sum at Least K

# ArrayDeque

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        long[] sum = new long[nums.length + 1];
        for(int i = 1; i < sum.length; i++){
            sum[i] = sum[i-1] + nums[i-1];
        }
        ArrayDeque<Integer> list = new ArrayDeque();
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < sum.length; i++){
            while(!list.isEmpty() && sum[i] - sum[list.peekFirst()] >= k){
                res = Math.min(res, i - list.pollFirst());
            }
            while(!list.isEmpty() && sum[list.peekLast()] >= sum[i]){
                list.pollLast();
            }
            list.offerLast(i);
        }
        return res <= nums.length? res: -1;
    }
}
```
