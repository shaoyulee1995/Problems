# Sliding windows
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of nums
```
class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] score = new int[n];
        Deque<Integer> deque = new LinkedList();
        score[0] = nums[0];
        deque.offerLast(0);
        for(int i = 1; i < n; i++){
            while(deque.peekFirst() != null && deque.peekFirst() < i - k){
                deque.pollFirst();
            }
            score[i] = score[deque.peekFirst()] + nums[i];
            while(deque.peekLast() != null && score[i] >= score[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        return score[n-1];
    }
}
```