# Array
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of nums
```
class Solution {
    public int[] sortedSquares(int[] nums) {
        int i = 0,
            j = nums.length -1,
            k = nums.length - 1;
        int[] res = new int[nums.length];
        while(i <= j){
            int x = Math.abs(nums[i]),
                y = Math.abs(nums[j]);
            if(x > y){
                res[k] = x*x;
                i++;
            }else{
                res[k] = y*y;
                j--;
            }
            k--;
        }
        return res;
    }
}
```