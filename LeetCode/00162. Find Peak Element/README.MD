# Binary Search
* Time Complexity: O(log(N))
* Space Complexity: O(1)
	* N as length of nums
```
class Solution {
    public int findPeakElement(int[] nums) {
        int i = 0,
            j = nums.length-1;
        while(i < j){
            int k = i + (j-i)/2;
            if(nums[k] < nums[k+1]){
                i = k+1;
            }else{
                j = k;
            }
        }
        return i;
    }
}
```