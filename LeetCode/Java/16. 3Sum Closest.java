class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE, res = 0;
        Arrays.sort(nums);
        for(int i = 0; i + 2 < nums.length && diff != 0; i++){
            int j = i + 1, k = nums.length - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target){
                    return sum;
                }
                if(Math.abs(sum - target) < Math.abs(diff)){
                    diff = target - sum;
                }
                if(sum < target){
                    j++;
                }else{
                    k--;
                }

            }

        }
        return target - diff;
    }
}