# Count Elements With Maximum Frequency

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```java
class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        int res = 0,
            maxFreq = 0;
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(num));
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(maxFreq == entry.getValue()){
                res += entry.getValue();
            }
        }
        return res;
    }
}
```