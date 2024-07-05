# Rearrange Characters to Make Target String

- Time Complexity: O(Min(S, T))
- Space Complexity: O(26)
  - S as length of s
  - T as length of target

```
class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] targetCnt = new int[26];
        for(char c: target.toCharArray()){
            targetCnt[c-'a']++;
        }
        int[] sCnt = new int[26];
        for(char c: s.toCharArray()){
            sCnt[c-'a']++;
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i++){
            if(targetCnt[i] == 0){
                continue;
            }
            int min = sCnt[i]/targetCnt[i];
            res = Math.min(min, res);
        }
        return res;
    }
}
```
