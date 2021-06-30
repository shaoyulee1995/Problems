class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int n: nums){
            if(map.containsKey(n))
                continue;
            int left = (map.containsKey(n-1))?map.get(n-1):0,
                right = (map.containsKey(n+1))?map.get(n+1):0,
                total = left + right + 1;
            
            map.put(n-left, total);
            map.put(n+right, total);
            map.put(n, total);
            ans = Math.max(ans, total);
        }
        return ans;
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length == 0 || nums == null)
            return 0;
        Arrays.sort(nums);
        int cur = nums[0],
            max = 1, sum = 1;
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1])
                continue;
            if(nums[i] == cur + 1){
                cur++;
                sum++;
            }else{
                cur = nums[i];
                sum = 1;
            }
            max = Math.max(max, sum);
        }
        return max;
}