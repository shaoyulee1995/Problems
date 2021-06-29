class Solution {
    public int sumOfUnique(int[] nums) {
        int[] cnt = new int[101];
        
        for(int num: nums){
            cnt[num]++;
        }
        
        int sum = 0;
        for(int i = 1; i < cnt.length; i++){
            if(cnt[i] == 1){
                sum += i;
            }
        }
        return sum;
    }
}