* Time Complexity: O(N*W*P)
	* N represents number of words
	* W represents the length of word
	* P represents the pattern
* Space Complexity: O(k)

```
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length() -1);
            }
        }
        return prefix;
    }
}
```