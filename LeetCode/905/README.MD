# Sort Array By Parity
# Array
* Time Complexity: O(N)
* Space Complexity: O(1)
    * N as length of nums
```
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0,
            j = nums.length-1;
        while(i < j){
            if(nums[j]%2==0 && nums[i]%2 == 1){
                swap(nums, i, j);
            }
            if(nums[i]%2 == 0){
                i++;
            }
            if(nums[j]%2 == 1){
                j--;
            }
        }
        return nums;
    }
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
```