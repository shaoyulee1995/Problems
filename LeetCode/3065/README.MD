# Minimum Operations to Exceed Threshold Value I

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public int minOperations(int[] nums, int k) {
        return (int)Arrays.stream(nums).filter(x -> x < k).count();
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public int minOperations(int[] nums, int k) {
        int res = 0;
        for(int num: nums){
            if(num < k){
                res++;
            }
        }
        return res;
    }
}
```
