class Solution {
    public int[] findErrorNums(int[] nums) {
        int a = 0, b= nums.length; 
        int[] cnt = new int[nums.length + 1];
        for(int num: nums){
            cnt[num]++;
        }
        
        for(int i = 1; i < cnt.length; i++){
            if(cnt[i] == 2){
                a = i;
            }
            if(cnt[i] == 0){
                b = i;
            }
        }
        return new int []{a,b};
    }
}