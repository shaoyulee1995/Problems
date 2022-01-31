# Counting
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of s
```
class Solution {
    public boolean checkValidString(String s) {
        int openMin = 0, openMax = 0;
        for(char c: s.toCharArray()){
            if(c == '('){
                openMin++;
                openMax++;
            }else if(c == ')'){
                openMin--;
                openMax--;
            }else if(c == '*'){
                openMin--;
                openMax++;
            }
            if(openMax < 0){
                return false;
            }
            openMin = Math.max(0, openMin);
        }
        return openMin == 0;
    }
}
```