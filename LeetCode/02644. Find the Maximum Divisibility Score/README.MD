# Array
* Time Complexity: O(DN)
* Space Complexity: O(N)
    * N as length of nums
    * D as length of divisors
```
class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        int maxCount = 0,
            res = divisors[0];
        for(int divisor: divisors){
            int count = 0;
            for(int num: nums){
                count += (num%divisor == 0)? 1: 0;
            }
            if(count > maxCount){
                maxCount = count;
                res = divisor;
            }else if(count == maxCount){
                res = Math.min(res, divisor);
            }
        }
        return res;
    }
}
```