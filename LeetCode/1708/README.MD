# Largest Subarray Length K

- Time Complexity: O(N)
- Space Complexity: O(k)
  - N as length of nums
  - k as k

```java
class Solution {
    public int[] largestSubarray(int[] nums, int k) {
        int maxIndex = 0,
            max = 0;
        for(int i = nums.length-k; i >= 0; i--){
            if(nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
        }
        return Arrays.copyOfRange(nums, maxIndex, maxIndex+k);
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(k)
  - N as length of nums
  - k as k

```java
class Solution {
    public int[] largestSubarray(int[] nums, int k) {
        if(k > nums.length){
            return null;
        }
        int max = Integer.MIN_VALUE,
            maxIndex = 0;
        for(int i = nums.length-k; i >= 0; i--){
            if(nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
        }
        int[] res = new int[k];
        for(int i = maxIndex; i < maxIndex+k; i++){
            res[i-maxIndex] = nums[i];
        }
        return res;
    }
}
```
