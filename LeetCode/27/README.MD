# Remove Element

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int idx = 0;
        for(int num: nums){
            if(num != val){
                nums[idx++] = num;
            }
        }
        return idx;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0,
            j = 0;
        while(j < nums.length){
            if(nums[j] != val){
                nums[i++] = nums[j];
            }
            j++;
        }
        return i;
    }
}
```
