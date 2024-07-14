# Majority Element

- Time Complexity: O(NlogN)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
```

# Count

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public int majorityElement(int[] nums) {
        int res = 0,
            count = 0;
        for(int num: nums){
            if(count == 0){
                res = num;
            }
            count += (num == res)? 1: -1;
        }
        return res;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public int majorityElement(int[] nums) {
        return divide(nums, 0, nums.length - 1);
    }

    public int divide(int[] nums, int start, int end){
        if(start == end){
            return nums[start];
        }
        int mid = start + (end - start)/2;
        int leftResult = divide(nums, start, mid),
            rightResult = divide(nums, mid + 1, end);
        if(leftResult == rightResult){
            return leftResult;
        }
        int leftCount = conquer(nums, leftResult, start, end),
            rightCount = conquer(nums, rightResult, start, end);
        return leftCount > rightCount? leftResult: rightResult;
    }

    public int conquer(int[] nums, int target, int start, int end){
        int cnt = 0;
        for(int i = start; i <= end; i++){
            if(nums[i] == target){
                cnt++;
            }
        }
        return cnt;
    }
}
```
