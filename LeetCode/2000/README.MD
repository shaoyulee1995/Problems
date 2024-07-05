# Reverse Prefix of Word

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of words

```
class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            sb.append(c);
            if(c == ch){
                return sb.reverse().toString() + word.substring(i+1, word.length());
            }
        }
        return word;
    }
}
```
