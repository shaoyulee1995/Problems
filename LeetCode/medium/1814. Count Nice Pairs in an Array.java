class Solution {
    //nums[i] - rev(nums[ji]) == nums[j] - rev(nums[j])
    
    /**
    original: [42,11,1,97]
    reverse:  [24,11,1,79]
    diff:     [18,0,0,18]
    */
    public int countNicePairs(int[] nums) {
        HashMap<Long, Integer> map = new HashMap();
        int cnt = 0;
        int mod = (int)(Math.pow(10,9) + 7);
        for(int num: nums){
            long rev = rev(num);
            long diff = num - rev;
            if(map.containsKey(diff)){
                cnt = ((cnt%mod) + map.get(diff)%mod)%mod;
            }
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        return cnt;
    }
    private long rev(int num){
        long ans = 0;
        while(num!=0){
            ans = ans*10 + num%10;
            num/=10;
        }
        return ans;
    }
}