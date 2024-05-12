# Verifying an Alien Dictionary
# Counting Array
* Time Complexity: O(W*MAX(w)
* Space Complexity: O(W)
	* W as length of words
	* w as longest word in words
```
class Solution {
    int[] pattern;
    public boolean isAlienSorted(String[] words, String order) {
        pattern = new int[order.length()];
        for(int i = 0; i < order.length(); i++){
            pattern[order.charAt(i)-'a'] = i;
        }   
        for(int i = 1; i < words.length; i++){
            if(notValid(words[i-1], words[i])){
                return false;
            }
        }
        return true;
    }
    public boolean notValid(String word1, String word2){
        int n = word1.length(),
            m = word2.length();
        for(int i = 0; i < n && i < m; i++){
            char w1 = word1.charAt(i),
                 w2 = word2.charAt(i);
            if(w1 != w2){
                return pattern[w1-'a'] > pattern[w2-'a'];
            }
        }
        return n>m;
    }
}
```