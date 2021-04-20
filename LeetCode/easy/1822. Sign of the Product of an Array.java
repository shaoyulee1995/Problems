class Solution {
    public int arraySign(int[] nums) {
        int cntNeg = 0;
        for(int num: nums){
            if(num == 0){
                return 0;
            }
            if(num < 0){
                cntNeg++;
            }
        }
        return (cntNeg%2==1)?-1:1;
    }
}