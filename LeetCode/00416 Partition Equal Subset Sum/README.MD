# TLE
```
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        if(sum % 2 != 0){
            return false;
        }
        sum /= 2;
        return canPartition(nums, sum, 0);
    }
    public boolean canPartition(int[] nums,  int target, int index){
        if(target == 0){
            return true;
        }
        if(index < 0 || index == nums.length){
            return false;
        }
        if(canPartition(nums, target - nums[index], index + 1)){
            return true;
        }
        int j = index + 1;
        while(j < nums.length && nums[j] == nums[index]){
            j++;
        }
        return canPartition(nums, target, j);
    } 
}
```