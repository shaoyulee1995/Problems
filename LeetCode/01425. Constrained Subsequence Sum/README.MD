# Deque
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of nums
```
class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque();
        int[] sum = new int[nums.length];
        int res = nums[0];
        for(int i = 0; i < nums.length; i++){
            sum[i] = nums[i];
            if(!deque.isEmpty()){
                sum[i] += sum[deque.peekFirst()];
            }
            res = Math.max(res, sum[i]);
            
            if(!deque.isEmpty() && deque.peekFirst() < (i-k+1)){
                deque.pollFirst();
            }
            while(!deque.isEmpty() && sum[deque.peekLast()] <= sum[i]){
                deque.pollLast();
            }
            if(sum[i] > 0){
                deque.offer(i);
            }
        }
        return res;
    }
}
```