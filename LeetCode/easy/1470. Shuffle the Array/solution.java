class Solution {
    public int[] shuffle(int[] nums, int n) {
        int left = 0, mid = n;
        int[] output = new int[nums.length];
        
        for(int i = 0; i < n; i++){
            output[left++] = nums[i];
            output[left++] = nums[mid++];
        }
        return output;
    }
}