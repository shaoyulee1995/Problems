# Find The Integer Added To Array 1

- Time Complexity: O(NlogN)
- Space Complexity: O(1)
  - N as length of nums1
```java
class Solution {
    public int addedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        return nums2[0] - nums1[0];
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums1

```java
class Solution {
    public int addedInteger(int[] nums1, int[] nums2) {
        int min1 = Integer.MAX_VALUE,
            min2 = Integer.MAX_VALUE;
        for(int num: nums1){
            min1 = Math.min(min1, num);
        }
        for(int num: nums2){
            min2 = Math.min(min2, num);
        }
        return min2 - min1;
    }
}
```