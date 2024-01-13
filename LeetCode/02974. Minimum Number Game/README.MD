# PriorityQueue
* Time Complexity: O(NlogN)
* Space Complexity: O(N)
	* N as length of nums
```
class Solution {
    public int[] numberGame(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int num: nums){
            pq.add(num);
        }
        int[] res = new int[nums.length];
        int i = 0;
        while(!pq.isEmpty()){
            int Alice = pq.poll(),
                Bob = pq.poll();
            res[i++] = Bob;
            res[i++] = Alice;
        }
        return res;
    }
}
```
# Sort
* Time Complexity: O(NlogN)
* Space Complexity: O(N)
	* N as length of nums
```
class Solution {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i += 2){
            res[i] = nums[i+1];
            res[i+1] = nums[i];
        }
        return res;
    }
}
```