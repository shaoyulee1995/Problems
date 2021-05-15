class Solution {
    public int subarraySum(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        int sum = 0, cnt = 0;
        map.put(0,1);
        
        for(int num: nums){
            sum += num;
            if(map.containsKey(sum-k)){
                cnt += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }
}