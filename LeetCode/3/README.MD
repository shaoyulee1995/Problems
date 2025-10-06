# Longest Substring Without Repeating Characters

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of s

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0,
            j = 0,
            res = 0;
        HashSet<Character> set = new HashSet();
        while(j < s.length()){
            char c = s.charAt(j);
            if(!set.contains(c)){
                set.add(c);
                j++;
                res = Math.max(res, set.size());
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return res;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of s

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        HashSet<Character> seen = new HashSet();
        for (int i = 0, j = 0; j < s.length();) {
            if (seen.add(s.charAt(j))) {
                res = Math.max(res, seen.size());
                j++;
            } else {
                seen.remove(s.charAt(i));
                i++;
            }
        }
        return res;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of s

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Set<Character> set = new HashSet();
        for(int i = 0, j = 0; j < s.length(); j++){
            while(!set.add(s.charAt(j))){
                set.remove(s.charAt(i++));
            }
            res = Math.max(res, set.size());
        }
        return res;
    }
}
```