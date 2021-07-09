class Solution {
    public int maxProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE,
            max2 = max1;
        
        for(int num: nums){
            if(num > max2){
                max1 = max2;
                max2 = num;
            }else if(num > max1){
                max1 = num;
            }
        }
        return (max1-1)*(max2-1);
    }
}