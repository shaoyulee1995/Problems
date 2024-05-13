# Median of Two Sorted Arrays

- Time Complexity: O(log(N+M))
- Space Complexity: O(1)
  - N as length of nums1
  - M as length of nums2

```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if(nums1.length > nums2.length){
        return findMedianSortedArrays(nums2, nums1);
    }
    int left = 0,
        right = nums1.length;
    while(left <= right){
        int x = left + (right - left)/2,
            y = (nums1.length + nums2.length + 1)/2 - x;

        int xLeft = (x == 0)? (Integer.MIN_VALUE): nums1[x-1],
            xRight = (x == nums1.length)? (Integer.MAX_VALUE): nums1[x],
            yLeft = (y == 0)?(Integer.MIN_VALUE): nums2[y-1],
            yRight = (y == nums2.length)? (Integer.MAX_VALUE): nums2[y];
        if(xLeft <= yRight && yLeft <= xRight){
            if((nums1.length + nums2.length)%2 == 0){
                return ((double)Math.max(xLeft, yLeft) + Math.min(xRight, yRight))/2;
            }
            return (double)Math.max(xLeft, yLeft);
        }else if(xRight > yLeft){
            right = x - 1;
        }else{
            left = x + 1;
        }
    }
    return -1;
    }
}
```
