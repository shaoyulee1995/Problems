```
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        if(nums.length == 0){
            return list;
        }
        Arrays.sort(nums);
        backtrack(list, new ArrayList(), new boolean[nums.length], nums);
        return list;
    }
    private void backtrack(List<List<Integer>> list,
                           List<Integer> temp, 
                           boolean[] visited,
                           int[] nums){
        if(temp.size() == nums.length){
            list.add(new ArrayList(temp));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(visited[i] == true){
                continue;
            }
            if(i > 0 && nums[i] == nums[i-1] && !visited[i-1]){
                continue;
            }
            temp.add(nums[i]);
            visited[i] = true;
            backtrack(list, temp, visited, nums);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }
}
```