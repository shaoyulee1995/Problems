# Random Pick Index

- Time Complexity: O(R)
- Space Complexity: O(N)
  - R as Random
  - N as length of nums

```java
class Solution {

    int[] nums;
    Random random;
    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }
    
    public int pick(int target) {
        while(true){
            int nextInt = random.nextInt(nums.length);
            if(target == nums[nextInt]){
                return nextInt;
            }
        }
    }
}
```
```java
Your Solution object will be instantiated and called as such:
Solution obj = new Solution(nums);
int param_1 = obj.pick(target);
```