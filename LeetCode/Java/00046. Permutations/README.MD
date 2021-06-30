```
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        backtrack(list, new boolean[nums.length], new ArrayList(), nums);
        return list;
    }
    private void backtrack(List<List<Integer>> list, boolean[] visited, List<Integer> temp, 
                          int[] nums){
        if(temp.size() == nums.length){
            list.add(new ArrayList(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i] == true){
                continue;
            }
            visited[i] = true;
            temp.add(nums[i]);
            backtrack(list, visited, temp, nums);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }
}
```