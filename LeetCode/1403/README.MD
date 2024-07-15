# Minimum Subsequence in Non-Increasing Order

- Time Complexity: O(NlogN)
- Space Complexity: O(N)
  - N as length of nums

```java
class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> res = new ArrayList();
        int totalSum = 0,
            subSum = 0;
        for(int num: nums){
            pq.add(num);
            totalSum += num;
        }
        while(totalSum >= subSum){
            if(!pq.isEmpty()){
                int num = pq.poll();
                totalSum -= num;
                subSum += num;
                res.add(num);
            }
        }
        return res;
    }
}
```
