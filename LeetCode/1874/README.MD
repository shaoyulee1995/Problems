# Minimize Product Sum of Two Arrays

- Time Complexity: O(NlogN)
- Space Complexity: O(1)
  - N as length of nums1

```java
class Solution {
    public int minProductSum(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int res = 0;
        for(int i = 0, j = nums2.length-1; i < nums1.length; i++, j--){
            res += nums1[i] * nums2[j];
        }
        return res;
    }
}
```
