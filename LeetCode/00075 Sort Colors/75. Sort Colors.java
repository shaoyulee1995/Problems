class Solution {
    public void sortColors(int[] nums) {
        int redIndex = 0, 
            whiteIndex = 0,
            blueIndex = nums.length - 1;
        while(whiteIndex <= blueIndex){
            if(nums[whiteIndex] == 0){
                swap(nums, whiteIndex++, redIndex++);
            }else if(nums[whiteIndex] == 1){
                whiteIndex ++;
            }else{
                swap(nums, whiteIndex, blueIndex--);
            }
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}