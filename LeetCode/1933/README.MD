# Check if String Is Decomposable Into Value-Equal Substrings

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of s

```java
class Solution {
    public boolean isDecomposable(String s) {
        if(s.length() % 3 != 2){
            return false;
        }
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            int j = i;
            while(j < s.length() && s.charAt(i) == s.charAt(j)){
                j++;
            }
            if((j-i)%3 == 1){
                return false;
            }
            if((j-i)%3 == 2){
                res++;
            }
            if(res == 2){
                return false;
            }
            i = j-1;
        }
        return res==1;
    }
}
```
