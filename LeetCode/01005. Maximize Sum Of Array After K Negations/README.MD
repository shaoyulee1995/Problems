# Greedy
* Time Complexity: O(Nlog(N))
* Space Complexity: O(N)
	* N as length of nums
```
class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int num: nums){
            pq.add(num);
        }
        while(k > 0){
            pq.add(-pq.poll());
            k--;
        }
        int res = 0;
        while(!pq.isEmpty()){
            res += pq.poll();
        }
        return res;
    }
}
```