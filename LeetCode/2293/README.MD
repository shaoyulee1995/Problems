# Min Max Game

# Array

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```
class Solution {
    public int minMaxGame(int[] nums) {
        while(nums.length > 1){
            int[] cur = new int[nums.length/2];
            for(int i = 0; i < cur.length; i++){
                if(i%2 == 0){
                    cur[i] = Math.min(nums[i*2], nums[i*2+1]);
                }else{
                    cur[i] = Math.max(nums[i*2], nums[i*2+1]);
                }
            }
            nums = cur;
        }
        return nums[0];
    }
}
```

# Recursion

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```
class Solution {
    public int minMaxGame(int[] nums) {
        while(nums.length > 1){
            int[] cur = new int[nums.length/2];
            for(int i = 0; i < cur.length; i++){
                if(i%2 == 0){
                    cur[i] = Math.min(nums[i*2], nums[i*2+1]);
                }else{
                    cur[i] = Math.max(nums[i*2], nums[i*2+1]);
                }
            }
            return minMaxGame(cur);
        }
        return nums[0];
    }
}
```
