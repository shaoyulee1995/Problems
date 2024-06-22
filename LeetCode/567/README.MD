# Permutation in String

- Time Complexity: O(max(N, M))
- Space Complexity: O(26)
  - N: length of t
  - M: length of p

```java
class Solution {
    public boolean checkInclusion(String t, String p) {
        int len1 = t.length(), len2 = p.length();
        if(len1 > len2){
            return false;
        }
        int[] cnt = new int[26];
        for(int i = 0; i < len1; i++){
            cnt[t.charAt(i)-'a']++;
        }

        for(int i = 0; i < len2; i++){
            if(i - len1 >= 0){
                cnt[p.charAt(i-len1)-'a']++;
            }
            cnt[p.charAt(i)-'a']--;
            if(zeroCheck(cnt)){
                return true;
            }
        }
        return false;
    }
    private boolean zeroCheck(int[] cnt){
        for(int i = 0; i < cnt.length; i++){
            if(cnt[i] != 0){
                return false;
            }
        }
        return true;
    }
}
```
