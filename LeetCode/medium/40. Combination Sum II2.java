class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList();
        backTrack(ans, new ArrayList(candidates.length), new boolean[candidates.length], target, 0, candidates);
        return ans;
    }
    private void backTrack(List<List<Integer>> list, List<Integer> temp, boolean[] visited, int remain, int index, int[] nums){
        if(remain == 0){
            list.add(new ArrayList(temp));
            return;
        }
        if(remain < 0){
            return;
        }
        for(int i = index; i < nums.length; i++){
            if(visited[i]){
                continue;
            }
            if(remain - nums[i] < 0){
                continue;
            }
            if(i>0 && nums[i] == nums[i-1] && !visited[i-1]){
                continue;
            }
            visited[i] = true;
            temp.add(nums[i]);
            backTrack(list, temp, visited, remain - nums[i], i+1, nums);
            visited[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}