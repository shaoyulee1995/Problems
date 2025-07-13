# Find the Number of Good Pairs I

- Time Complexity: O(NM)
- Space Complexity: O(1)
  - N as length of nums1
  - M as length of nums2

```java
class Solution {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int res = 0;
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                if(nums1[i]%(nums2[j]*k) == 0){
                    res++;
                }
            }
        }
        return res;    
    }
}
```