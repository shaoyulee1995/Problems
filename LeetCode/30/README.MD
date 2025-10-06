# Substring with Concatenation of All Words

- Time Complexity: O(SW)
- Space Complexity: O(N)
  - N as length of words
  - W as length of word
  - S as length of s

```java
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList();
        HashMap<String, Integer> map = new HashMap();
        for (String word : words) {
            map.merge(word, 1, Integer::sum);
        }
        int totalFreq = words.length,
            wordLength = words[0].length();
        for (int i = 0; i < wordLength; i++) {
            int l = i,
                r = i,
                freq = 0;
            HashMap<String, Integer> trackingMap = new HashMap();
            while (r + wordLength <= s.length()) {
                String currentWord = s.substring(r, r + wordLength);
                r += wordLength;
                if (!map.containsKey(currentWord)) {
                    freq = 0;
                    trackingMap.clear();
                    l = r;
                    continue;
                }

                trackingMap.merge(currentWord, 1, Integer::sum);
                freq++;

                while (trackingMap.get(currentWord) > map.get(currentWord)) {
                    String removedWord = s.substring(l, l + wordLength);
                    l += wordLength;
                    trackingMap.merge(removedWord, -1, Integer::sum);
                    freq--;
                }

                if (freq == totalFreq) {
                    res.add(l);
                }
            }
        }
        return res;
    }
}
```