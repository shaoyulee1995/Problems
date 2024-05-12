# Jump Game II
# Greedy
* Time Complexity: O(N)
* Space Complexity: O(1)
```
class Solution {
    public int jump(int[] nums) {
        int curPosition = 0,
            nextPosition = 0, 
            steps = 0;
        for(int i = 0; i < nums.length-1; i++){
            nextPosition = Math.max(i + nums[i], nextPosition);
            if(curPosition == i){
                curPosition = nextPosition;
                steps++;
            }
        }
        return steps;
    }
}
```