# Check if All Characters Have Equal Number of Occurrences

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of s

```
class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] cnt = new int[26];
        for(char c: s.toCharArray()){
            cnt[c-'a']++;
        }
        Integer freq = null;
        for(int c: cnt){
            if(c == 0){
                continue;
            }
            if(freq == null || freq == c){
                freq = c;
            }else{
                return false;
            }
        }
        return true;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of s

```
class Solution {
    public boolean areOccurrencesEqual(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        Map<Character, Integer> map = new HashMap();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Set<Integer> set = new HashSet();
        for(int value: map.values()){
            set.add(value);
        }
        return set.size() == 1;
    }
}
```
