# Unique Morse Code Words

- Time Complexity: O(Ww)
- Space Complexity: O(max(W, 26))
  - w as length of word
  - W as length of words

```
class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] alphabet = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        HashSet<String> set = new HashSet();
        for(String word: words){
            char[] wordC = word.toCharArray();
            StringBuilder sb = new StringBuilder();
            for(char c: wordC){
                sb.append(alphabet[c-'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
```
