# ArrayDeque
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of nums
```
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        ArrayDeque<Integer> min = new ArrayDeque(),
                            max = new ArrayDeque();
        int i = 0, j = 0;
        for(; j < nums.length; j++){
            while(!max.isEmpty() && nums[j] > max.peekLast()){
                max.pollLast();
            }
            while(!min.isEmpty() && nums[j] < min.peekLast()){
                min.pollLast();
            }
            max.offerLast(nums[j]);
            min.offerLast(nums[j]);
            if(max.peekFirst() - min.peekFirst() > limit){
                if(max.peekFirst() == nums[i]){
                    max.pollFirst();
                }
                if(min.peekFirst() == nums[i]){
                    min.pollFirst();
                }
                i++;
            }
        }
        return j - i;
    }
}
```