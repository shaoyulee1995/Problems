# Sliding windows
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of nums
```
class Solution {
    public int maxResult(int[] nums, int k) {
        int[] score = new int[nums.length];
        score[0] = nums[0];
        ArrayDeque<Integer> deque = new ArrayDeque();
        deque.offer(0);
        for(int i = 1; i < nums.length; i++){
            while(deque.peekFirst() != null && deque.peekFirst() + k < i){
                deque.pollFirst();
            }
            score[i] = score[deque.peekFirst()] + nums[i];
            if(deque.peekLast() != null && score[i] >= score[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }        
        return score[nums.length - 1];
    }
}
```