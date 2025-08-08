# Longest Palindrome by Concatenating Two Letter Words

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of words

```java
class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> nonPair = new HashMap();
        int sym = 0,
            pair = 0;
        for(String word: words){
            String reverse = new StringBuilder(word).reverse().toString();
            if(nonPair.getOrDefault(reverse, 0) > 0){
                nonPair.merge(reverse, -1, Integer:: sum);
                pair++;
                sym -= (word.charAt(0) == word.charAt(1))? 1: 0;
            }else{
                nonPair.merge(word, 1, Integer::sum);
                sym += (word.charAt(0) == word.charAt(1))? 1: 0;
            }
        }
        return 4*pair + ((sym > 0)? 2: 0);
    }
}
```