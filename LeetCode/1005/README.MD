# Maximize Sum Of Array After K Negations

# Greedy

- Time Complexity: O(Nlog(N))
- Space Complexity: O(N)
  - N as length of nums

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

# Greedy

- Time Complexity: O(Nlog(N))
- Space Complexity: O(1)
  - N as length of nums

```
class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        nums = IntStream.of(nums)
                .boxed()
                .sorted((a,b) -> Math.abs(b) - Math.abs(a))
                .mapToInt(Integer::intValue)
                .toArray();
        for(int i = 0; i < nums.length && k > 0; i++){
            if(nums[i] < 0){
                nums[i] *= -1;
                k--;
            }
        }
        if(k%2 == 1){
            nums[nums.length-1] *= -1;
        }
        return Arrays.stream(nums).sum();
    }
}
```
