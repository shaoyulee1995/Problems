# Check If A Number Is Majority Element in a Sorted Array

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as the size of nums

```java
class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int res = 0;
        for(int num: nums){
            if(num == target){
                res++;
            }
        }
        return res > nums.length/2;
    }
}
```

- Time Complexity: O(logN)
- Space Complexity: O(1)
  - N as the size of nums

```java
class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int firstOccurance = lowerBound(nums, target),
            lastOccurance = upperBound(nums, target);
        return (lastOccurance - firstOccurance) > nums.length/2;
    }

    public int lowerBound(int[] nums, int target){
        int i = 0,
            j = nums.length-1,
            idx = nums.length;
        while(i <= j){
            int k = i + (j-i)/2;
            if(nums[k] >= target){
                j = k-1;
                idx = k;
            }else{
                i = k+1;
            }
        }
        return idx;
    }

    public int upperBound(int[] nums, int target){
        int i = 0, 
            j = nums.length-1;
        while(i <= j){
            int k = i + (j-i)/2;
            if(nums[k] > target){
                j = k-1;
            }else{
                i = k+1;
            }
        }
        return i;
    }
}
```

- Time Complexity: O(logN)
- Space Complexity: O(1)
  - N as the size of nums

```java
class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int firstOccurance = lowerBound(nums, target),
            lastOccurance = firstOccurance + (nums.length/2);
        return (lastOccurance < nums.length && nums[lastOccurance] == target);
    } 
    public int lowerBound(int[] nums, int target){
        int i = 0,
            j = nums.length;
        while(i < j){
            int k = i + (j-i)/2;
            if(nums[k] < target){
                i = k+1;
            }else{
                j = k;
            }
        }
        return i;
    }
}
```