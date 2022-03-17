# Sort
* Time Complexity: O(Nlog(N))
* Space Complexity: O(1)
	* N as length of nums
```
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
```
# Heap, PriorityQueue
* Time Complexity: O(Nlog(K))
* Space Complexity: O(K)
	* N as length of nums
	* K as k
```
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->a-b);
        for(int num: nums){
            pq.add(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.poll();
    }
}
```