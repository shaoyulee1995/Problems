# Search Insert Position

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target || nums[i] > target){
                return i;
            }
        }
        return nums.length;
    }
}
```

- Time Complexity: O(logN)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0,
            j = nums.length-1;
        while(i < j){
            int k = i + (j-i)/2;
            if(nums[k] == target){
                return k;
            }
            if(nums[k] > target){
                j = k;
            }else{
                i = k+1;
            }
        }
        return nums[i] < target? i+1: i;
    }
}
```
