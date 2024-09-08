# Maximum Number of Operations With the Same Score I

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public int maxOperations(int[] nums) {
        if(nums.length < 2){
            return 0;
        }
        int sum = nums[0] + nums[1],
            count = 1;
        for(int i = 2; i+1< nums.length; i+=2){
            if(nums[i] + nums[i+1] == sum){
                count++;
            }else{
                break;
            }
        }
        return count;
    }
}
```
