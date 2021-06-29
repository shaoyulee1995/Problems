class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList();
        for(int i = 0; i < nums.length; i++){
            int j = Math.abs(nums[i]) - 1;
            nums[j] = -1*Math.abs(nums[j]);
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                ans.add(i+1);
            }
        }
        return ans;
    }
}