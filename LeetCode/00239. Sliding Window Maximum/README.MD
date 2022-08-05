# ArrayDeque
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of nums
```
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> list = new ArrayDeque();
        int idx = 0;
        int[] res = new int[nums.length - k + 1];
        for(int i = 0; i < nums.length; i++){
            while(!list.isEmpty() && i - k + 1 > list.peekFirst()){
                list.pollFirst();
            }
            while(!list.isEmpty() && nums[list.peekLast()] <= nums[i]){
                list.pollLast();
            }
            list.offerLast(i);
            if(i - k + 1 >= 0){
                res[idx++] = nums[list.peekFirst()];
            }
        }
        return res;
    }
}
```