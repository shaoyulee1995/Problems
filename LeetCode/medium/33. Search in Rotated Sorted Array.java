class Solution {
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while(i < j){
            int m = i + (j-i)/2;
            if(nums[m] == target){
                return m;
            }
            if(nums[i]<=nums[m]){
                if(nums[i] <= target && target < nums[m]){
                    j = m - 1;
                }else{
                    i = m + 1;
                }
            }else{
                if(nums[m] < target && target <= nums[j]){
                    i = m + 1;
                }else{
                    j = m -1;;
                }
            }
        }
        return nums[i] == target? i : -1;
    }
}

/*
nums = [4,5,6,7,0,1,2], target = 0

4,5,6,7,0,1,2    target = 0
i
            j 
          m
target between nums[i] and nums[m]?

target between nums[m] and nums[j]?

      
nums = [4,5,6,7,0,1,2], target = 3

4,5,6,7,0,1,2    target = 3
            i
            j
            m

*/