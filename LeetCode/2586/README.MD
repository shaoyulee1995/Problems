# Count the Number of Vowel Strings in Range

# Set

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length between left and right

```
class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        HashSet<Character> set = new HashSet(Arrays.asList('a', 'e','i', 'o', 'u'));
        int res = 0;
        for(int i = left; i <= right; i++){
            if(set.contains(words[i].charAt(0)) && set.contains(words[i].charAt(words[i].length()-1))){
                res++;
            }
        }
        return res;
    }
}
```
