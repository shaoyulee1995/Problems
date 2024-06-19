# Number of Good Ways to Split a String

# Counting Array

- Time Complexity: O(N)
- Space Complexity: O(26)

```
class Solution {
    public int numSplits(String s) {
        int[] cntL = new int[26],
              cntR = new int[26];
        int charsL = 0, charsR = 0, res = 0;
        for(char c: s.toCharArray()){
            if(++cntR[c-'a'] == 1){
                charsR++;
            }
        }
        for(char c: s.toCharArray()){
            if(++cntL[c-'a'] == 1){
                charsL++;
            }
            if(--cntR[c-'a'] == 0){
                charsR--;
            }
            if(charsL == charsR){
                res++;
            }
        }
        return res;
    }
}
```
