# Remove Duplicates from Sorted Array II

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int num: nums){
            if(i < 2 || num > nums[i-2]){
                nums[i++] = num;
            }
        }     
        return i;   
    }
}
```
