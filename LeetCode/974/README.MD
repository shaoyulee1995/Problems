# Subarray Sums Divisible by K

- Time Complexity: O(N)
- Space Complexity: O(K)
  - N as the length of nums
  - K as the value of k

```java
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] modGroup = new int[k];
        modGroup[0] = 1;
        int res = 0, 
            prefixSum = 0;
        for(int num: nums){
            prefixSum = (prefixSum + num%k + k) % k;
            res += modGroup[prefixSum];
            modGroup[prefixSum]++;
        }
        return res;    
    }
}
```