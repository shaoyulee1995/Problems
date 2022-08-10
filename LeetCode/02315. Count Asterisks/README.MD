# String
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of s
```
class Solution {
    public int countAsterisks(String s) {
        int res = 0, line = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '|'){
                line++;
            }else if(line%2 == 0 && c == '*'){
                res++;
            }
        }
        return res;
    }
}
```