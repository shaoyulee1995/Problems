# Remove Vowels from a String

# HashSet

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of s

```
class Solution {
    public String removeVowels(String s) {
        StringBuilder sb = new StringBuilder();
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
        for(char c: s.toCharArray()){
            if(!set.contains(c)){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
```
