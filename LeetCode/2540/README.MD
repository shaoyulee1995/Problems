# Minimum Common Value

# Pointers

- Time Complexity: O(Max(N,M))
- Space Complexity: O(1)
  - N as length of nums1
  - M as length of nums2

```java
class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int res = Integer.MAX_VALUE,
            i = 0,
            j = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                res = Math.min(res, nums1[i]);
                i++;
                j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }
        }
        return res == Integer.MAX_VALUE? -1: res;
    }
}
```
