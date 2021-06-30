class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3){
            return Collections.emptyList();
        }
        Set<List<Integer> > set = new HashSet();
        Arrays.sort(nums);
        for(int i = 0; i+2< nums.length; i++){
            int j = i + 1,
                k = nums.length - 1;
            while(j < k){
                if(nums[j] + nums[k] + nums[i] == 0){
                    set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }else if(nums[j] + nums[k] + nums[i] > 0){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return new ArrayList<>(set);
    }
}