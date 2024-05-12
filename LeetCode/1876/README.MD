# Substrings of Size Three with Distinct Characters
# String
* Time Complexity: O(N)
* Space Complexity: O(1)
    * N as length of s
```
class Solution {
    public int countGoodSubstrings(String s) {
        if(s.length() < 3){
            return 0;
        }   
        int res = 0;
        for(int i = 0; i+2 < s.length(); i++){
            char a = s.charAt(i),
                 b = s.charAt(i+1),
                 c = s.charAt(i+2);
            if(a != b && b != c && a != c){
                res++;
            }
        }
        return res;   
    }
}
```