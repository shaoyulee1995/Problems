class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 0;
        Integer candidate = null;
        for(int num: nums){
            if(cnt == 0){
                candidate = num;
            }
            cnt+=(num == candidate)?1:-1;
        }
        return candidate;
    }
}