# Maximum Number of Vowels in a Substring of Given Length

# Sliding Windows

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of s

```
class Solution {
    public int maxVowels(String s, int k) {
        int count = 0,
            res = 0;
        for(int i = 0; i < k; i++){
            count += (isVowel(s.charAt(i))? 1: 0);
        }
        res = count;
        for(int i = k; i < s.length(); i++){
            count += (isVowel(s.charAt(i))? 1: 0);
            count -= (isVowel(s.charAt(i-k))? 1: 0);
            res = Math.max(count, res);
        }
        return res;
    }

    public boolean isVowel(char c){
        return c == 'a' || c =='e' || c == 'i' || c == 'o' || c == 'u';
    }
}
```
