# Length of Last Word
# Array
* Time Complexity: O(S)
* Space Complexity: O(1)
	* S as length of s
```
class Solution {
    public int lengthOfLastWord(String s) {
        int res = 0;
        for(int i = s.length()-1; i >= 0; i--){
            char c = s.charAt(i);
            if(c == ' ' && res == 0){
                continue;
            }
            if(c != ' '){
                res++;
            }else{
                return res;
            }
        }
        return res;
    }
}
```