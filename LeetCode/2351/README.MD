# First Letter to Appear Twice

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of s

```java
class Solution {
    public char repeatedCharacter(String s) {
        HashSet<Character> set = new HashSet();
        for(char c: s.toCharArray()){
            if(!set.add(c)){
                return c;
            }
        }
        return ' ';
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of s

```java
class Solution {
    public char repeatedCharacter(String s) {
        int[] cnt = new int[26];
        for(char c: s.toCharArray()){
            cnt[c-'a']++;
            if(cnt[c-'a'] == 2){
                return c;
            }
        }
        return ' ';
    }
}
```
