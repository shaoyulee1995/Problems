# Monotonic Array

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```
class Solution {
    public boolean isMonotonic(int[] nums) {
       return increase(nums) || decrease(nums);
    }

    public boolean increase(int[] nums){
        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] > nums[i]){
                return false;
            }
        }
        return true;
    }

    public boolean decrease(int[] nums){
        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] < nums[i]){
                return false;
            }
        }
        return true;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```
class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean increase = true,
                decrease = true;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1]){
                decrease = false;
            }
            if(nums[i] < nums[i-1]){
                increase = false;
            }
        }
        return increase || decrease;
    }
}
```
