# Greatest English Letter in Upper and Lower Case

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of s

```java
class Solution {
    public String greatestLetter(String s) {
        int[] cnt = new int[128];
        for(char c: s.toCharArray()){
            cnt[c]++;
        }
        for(int i = 'z'; i >= 'a'; i--){
            if(cnt[i] > 0 && cnt[i-32] > 0){
                return Character.toString((char)(i-32));
            }
        }
        return "";
    }
}
```
