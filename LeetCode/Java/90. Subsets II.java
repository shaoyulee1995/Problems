class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        if(nums.length == 0){
            return list;
        }
        Arrays.sort(nums);
        backTrack(list, new ArrayList(), nums, 0);
        return list;
    }
    private void backTrack(List<List<Integer>> list, List<Integer> temp, int[] nums, int start){
        list.add(new ArrayList(temp));
        for(int i = start; i < nums.length; i++){
            if(i>start && nums[i] == nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            backTrack(list, temp, nums, i+1);
            temp.remove(temp.size() - 1);
        }
    }
}