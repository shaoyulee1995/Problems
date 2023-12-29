# Array
* Time Complexity: O(N)
* Space Complexity: O(1)
    * N as length of nums
```
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0,
            count = 0;
        for(int num: nums){
            if(num == 1){
                res = Math.max(res, ++count);
            }else{
                count = 0;
            }
        }
        return res;
    }
}
```