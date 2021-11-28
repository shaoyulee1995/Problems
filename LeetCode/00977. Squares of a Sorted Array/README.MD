# Array
* Time Complexity: O(N)
* Space Complexity: O(N)
```
class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0,
            n = nums.length,
            right = n - 1,
            index = n - 1;
        int[] res = new int[n];
        while(left <= right){
            if(Math.abs(nums[right]) > Math.abs(nums[left])){
                res[index--]=nums[right] * nums[right];
                right--;
            }else{
                res[index--]=nums[left]*nums[left];
                left++;
            }
        }
        return res;
    }
}
```