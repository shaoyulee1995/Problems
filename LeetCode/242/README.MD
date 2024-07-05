# Valid Anagram

- Time Complexity: O(Max(S,T))
- Space Complexity: O(26)
  - S as length of s.
  - T as length of T.

```
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] cnt = new int[26];
        for(char c: s.toCharArray()){
            cnt[c-'a']++;
        }
        for(char c: t.toCharArray()){
            cnt[c-'a']--;
            if(cnt[c-'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
```

- Time Complexity: O(Max(S,T))
- Space Complexity: O(26)
  - S as length of s.
  - T as length of T.

```
class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(char c: t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) - 1);
        }
        for(char c: map.keySet()){
            if(map.get(c) != 0){
                return false;
            }
        }
        return true;
    }
}
```
