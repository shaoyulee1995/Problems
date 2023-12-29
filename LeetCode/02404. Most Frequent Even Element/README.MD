# HashMap
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of nums
```
class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int num: nums){
            if(num%2 != 0){
                continue;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = Integer.MIN_VALUE,
            maxFreq = Integer.MIN_VALUE;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int num = entry.getKey(),
                freq = entry.getValue();
            if(freq > maxFreq){
                maxFreq = freq;
                res = num;
            }else if(freq == maxFreq){
                res = Math.min(res, num);
            }
        }
        return res == Integer.MIN_VALUE? -1: res;
    }
}
```