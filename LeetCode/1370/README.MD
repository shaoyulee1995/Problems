# Increasing Decreasing String

- Time Complexity: O(S)
- Space Complexity: O(S)
  - S as length of s

```
class Solution {
    public String sortString(String s) {
        StringBuilder sb = new StringBuilder();
        int[] cnt = new int[26];
        for(char c: s.toCharArray()){
            cnt[c-'a']++;
        }
        while(sb.length() != s.length()){
            for(int i = 0; i < 26; i++){
                if(cnt[i] > 0){
                    sb.append((char)(i+'a'));
                    cnt[i]--;
                }
            }
            for(int i = 25; i >= 0; i--){
                if(cnt[i] > 0){
                    sb.append((char)(i+'a'));
                    cnt[i]--;
                }
            }
        }
        return sb.toString();
    }
}
```
