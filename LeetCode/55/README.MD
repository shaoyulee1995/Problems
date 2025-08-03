# Jump Game

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public boolean canJump(int[] nums) {
        int jump = 0;
        for(int i = 0; i < nums.length && i <= jump; i++){
            jump = Math.max(jump, i + nums[i]);
            if(jump >= nums.length-1){
                return true;
            }
        }
        return false;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public boolean canJump(int[] nums) {
        int gas = 0;
        for(int num: nums){
            if(gas < 0){
                return false;
            }else if(num > gas){
                gas = num;
            }
            gas--;
        }
        return true;
    }
}
```
