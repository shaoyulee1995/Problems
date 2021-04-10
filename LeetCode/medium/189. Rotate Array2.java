class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k==0){return;}
        int[] output = nums.clone();
        int index = 0;
        for(int i = nums.length - k; i < nums.length; i++){
            nums[index++] = output[i];
        }
        for(int i = 0; i < nums.length - k;i++){
            nums[index++] = output[i];
        }
        
    }
}