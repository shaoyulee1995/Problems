# Arrays
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of nums
```
class Solution {
    public int maximumCount(int[] nums) {
        int negative = 0,
            positive = 0;
        for(int num: nums){
            if(num < 0){
                negative++;
            }else if(num > 0){
                positive++;
            }
        }
        return Math.max(positive, negative);
    }
}
```