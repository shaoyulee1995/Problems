class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList();
        backTrack(ans, new ArrayList(candidates.length), candidates, target, 0);
        return ans;
    }
    private void backTrack(List<List<Integer>> list, List<Integer> temp, int[] nums, int remain, int index){
        if(remain == 0){
            list.add(new ArrayList(temp));
            return;
        }
        if(remain < 0){
            return;
        }
        for(int i = index; i < nums.length; i++){
            if(remain - nums[i] < 0){
                continue;
            }
            temp.add(nums[i]);
            backTrack(list, temp, nums, remain - nums[i], i);
            temp.remove(temp.size() - 1);
        }
    }
}
