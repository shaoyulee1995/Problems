class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList();
        Arrays.sort(nums);
        backTrack(ans, new ArrayList(), target, 0, nums);
        return ans;
    }
    public void backTrack(List<List<Integer>> list, List<Integer> temp, 
                         int remain, int start, int[] nums){
        if(remain < 0){
            return;
        }
        if(remain == 0){
            list.add(new ArrayList(temp));
            return;
        }
        //10,1,2,7,6,1,5
        //1,1,2,5,6,7,10
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            backTrack(list, temp, remain - nums[i], i + 1, nums);
            temp.remove(temp.size() - 1);
        }
    }
}