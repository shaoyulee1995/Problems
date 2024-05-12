# Check If a Word Occurs As a Prefix of Any Word in a Sentence
# String
* Time Complexity: O(NW)
* Space Complexity: O(N)
	* N as length of sentence
```
class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] strs = sentence.split(" ");
        for(int i = 0; i < strs.length; i++){
            if(strs[i].length() < searchWord.length()){
                continue;
            }
            if(searchWord.equals(strs[i].substring(0, searchWord.length()))){
                return i+1;
            }
        }
        return -1;
    }
}
```