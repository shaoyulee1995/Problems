class Solution {
    public int jump(int[] nums) {
        int jump = 0, curEnd = 0, furtherest = 0;
        
        for(int i = 0; i < nums.length - 1 ; i++){
            furtherest = Math.max(furtherest, i + nums[i]);
            if(curEnd == i){
                jump++;
                curEnd = furtherest;
            }
        }
        return jump;
    }
}