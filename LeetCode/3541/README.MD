# Find Most Frequent Vowel and Consonant

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of s

```java
class Solution {
    public int maxFreqSum(String s) {
        int[] cnt = new int[26];
        int maxVowel = 0,
                maxConsonant = 0;
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
            if (isVowel(c)) {
                maxVowel = Math.max(maxVowel, cnt[c - 'a']);
            } else {
                maxConsonant = Math.max(maxConsonant, cnt[c - 'a']);
            }
        }
        return maxConsonant + maxVowel;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
```