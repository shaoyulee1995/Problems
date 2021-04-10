class Solution {
    public int[] decompressRLElist(int[] nums) {
        int sum_freq = 0;
        
        for(int i = 0; i < nums.length; i+=2){
            sum_freq += nums[i];
        }
        
        int[] output = new int[sum_freq];
        int j = 0;
        for(int i = 0; i < nums.length; i+=2){
            int freq = nums[i],
                val = nums[i+1];
            while(freq > 0){
                output[j++] = val;
                freq --;
            }
        }
        return output;
    }
}