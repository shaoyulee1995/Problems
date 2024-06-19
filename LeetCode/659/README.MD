# Split Array into Consecutive Subsequences

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```java
class Solution {
    public boolean isPossible(int[] nums) {
        HashMap<Integer, Integer> freqs = new HashMap(),
                                  append = new HashMap();
        for(int num: nums){
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);
        }

        for(int num: nums){
            if(freqs.get(num) == 0){
                continue;
            }
            if(append.getOrDefault(num-1, 0) > 0){
                append.put(num-1, append.get(num-1)-1);
                append.put(num, append.getOrDefault(num, 0) + 1);
            }else if(freqs.getOrDefault(num+1, 0) > 0 && freqs.getOrDefault(num+2, 0) > 0){
                freqs.put(num+1, freqs.get(num+1) - 1);
                freqs.put(num+2, freqs.get(num+2) - 1);
                append.put(num+2, append.getOrDefault(num+2, 0) + 1);
            }else{
                return false;
            }
            freqs.put(num, freqs.get(num) - 1);
        }
        return true;
    }
}
```
