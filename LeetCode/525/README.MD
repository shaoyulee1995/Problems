# Contiguous Array
# HashMap
* Time Complexity: O(N)
* Space Complexity: O(N)
```
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, -1);
        int val = 0, res = 0;
        for(int i = 0; i < nums.length; i++){
            val += nums[i] == 0?-1:1;
            if(map.containsKey(val)){
                res = Math.max(res, i - map.get(val));
            }else{
                map.put(val, i);
            }
        }
        return res;
    }
}
```