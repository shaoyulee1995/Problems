# HashMap
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of nums
```
class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        int res = 0;
        for(int num: nums){
            if(map.containsKey(num)){
                continue;
            }
            int left = (map.containsKey(num-1))? map.get(num-1): 0,
                right = (map.containsKey(num+1))? map.get(num+1): 0,
                len = right + left + 1;
            map.put(num-left, len);
            map.put(num+right, len);
            map.put(num, len);
            res = Math.max(res, len);
        }
        return res;
    }
}
```