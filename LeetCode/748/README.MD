# Shortest Completing Word

- Time Complexity: O(WL)
- Space Complexity: O(26)
  - W as length of words
  - L as length of word

```java
class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        licensePlate = licensePlate.toLowerCase();
        int[] cnt = new int[26];
        for(char c: licensePlate.toCharArray()){
            if(Character.isLetter(c)){
                cnt[c-'a']++;
            }
        }
        int minWordLength = Integer.MAX_VALUE;
        String res = null;
        for(String word: words){
            if(matchWord(word, cnt) && word.length() < minWordLength){
                minWordLength = word.length();
                res = word;
            }
        }
        return res;
    }

    public boolean matchWord(String word, int[] map){
        int[] cnt = new int[26];
        for(char c: word.toCharArray()){
            cnt[c-'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(map[i] != cnt[i] && cnt[i] < map[i]){
                return false;
            }
        }
        return true;
    }
}
```
