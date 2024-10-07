# Number of Distinct Averages

- Time Complexity: O(NlogN)
- Space Complexity: O(N)
  - N as length of nums

```java
class Solution {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        HashSet<Double> set = new HashSet();
        for(int i = 0; i < nums.length/2; i++){
            set.add((double)(nums[i] + nums[nums.length-1-i])/2);
        }
        return set.size();
    }
}
```