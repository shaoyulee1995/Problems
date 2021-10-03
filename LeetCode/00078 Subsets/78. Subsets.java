class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        if(nums.length == 0){
            return list;
        }
        // Arrays.sort(nums);
        backtrack(list, new ArrayList(), nums, 0);
        return list;
    }
    private void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums, int start){
        list.add(new ArrayList(temp));
        for(int i = start; i < nums.length; i++){
            temp.add(nums[i]);
            backtrack(list, temp, nums, i+1);
            temp.remove(temp.size() - 1);
        }
    }
}