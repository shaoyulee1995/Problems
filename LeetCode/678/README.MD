# Valid Parenthesis String
# Counting Opening
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
# Counting Left and Right individually
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of s
```
class Solution {
    public boolean checkValidString(String s) {
        int bal = 0;
        for(char c: s.toCharArray()){
            if(c == '(' || c == '*'){
                bal++;
            }else{
                bal--;
            }
            if(bal < 0){
                return false;
            }
        }
        if(bal == 0){
            return true;
        }
        bal = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            char c = s.charAt(i);
            if(c == ')' || c == '*'){
                bal++;
            }else{
                bal--;
            }
            if(bal < 0){
                return false;
            }
        }
        return true;
    }
}
```