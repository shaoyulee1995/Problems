class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer> > list = new ArrayList<>();
        if(nums.length < 3){
            return Collections.emptyList();
        }
        
        Set<List<Integer> > set = new HashSet<>();
        Arrays.sort(nums);
        
        
        for(int i = 0; i + 2< nums.length; i++){
            int j = i + 1, k = nums.length - 1, target = -nums[i];
            
            while(j < k){
                if(nums[i] + nums[j] + nums[k] == 0){
                    set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    k--;
                    j++;
                }else if(nums[j] + nums[k] > target){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return new ArrayList(set);
    }
}