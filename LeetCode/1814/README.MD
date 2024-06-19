# Count Nice Pairs in an Array

# HashMap

- Time Complexity: O(N)
- Space Complexity: O(N)

```
class Solution {
    public int countNicePairs(int[] nums) {
        HashMap<Long, Integer> map = new HashMap();
        int cnt = 0;
        int mod = (int)(1E9+7);
        for(int num: nums){
            long rev = rev(num);
            long diff = num - rev;
            if(map.containsKey(diff)){
                cnt = (cnt + map.get(diff))%mod;
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
```
