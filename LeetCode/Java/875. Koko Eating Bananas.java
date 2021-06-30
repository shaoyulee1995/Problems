class Solution {
    public int minEatingSpeed(int[] nums, int h) {
        int low = 0,
            high = 0;
        for(int num: nums){
            high = Math.max(num, high);
        }
        while(low < high){
            int mid = low + (high-low)/2;
            int cnt = 0;
            for(int num: nums){
                cnt+=Math.ceil((double)num/mid);
            }
            if(cnt > h){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }
}