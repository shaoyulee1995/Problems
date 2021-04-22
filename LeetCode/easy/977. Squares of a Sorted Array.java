class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        
        int left = 0,
            right = res.length - 1,
            index = right;
        while(left <= right){
            if(Math.abs(nums[right]) > Math.abs(nums[left])){
                res[index--] = nums[right] * nums[right];
                right--;
            }else{
                res[index--] = nums[left] * nums[left];
                left++;
            }
        }
        System.gc();
        return res;
    }
}