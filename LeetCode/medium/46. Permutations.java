class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        backtrack(ans, new boolean[nums.length], new ArrayList(), nums);
        return ans;
    }
    private void backtrack(List<List<Integer>> ans, boolean[] visited, List<Integer> temp, int[] nums){
        if(temp.size() == nums.length){
            ans.add(new ArrayList(temp));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(visited[i] == true){
                continue;
            }
            temp.add(nums[i]);
            visited[i] = true;
            backtrack(ans, visited, temp, nums);
            visited[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}