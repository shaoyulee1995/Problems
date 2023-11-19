# Math
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of s
```
class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s == null || s.length() == 0){
            return 0;
        }
        boolean isPositive = true;
        int i = 0;
        long res = 0;
        if(s.charAt(i) == '-' || s.charAt(i) == '+'){
            isPositive = (s.charAt(i++) == '+');
        }
        for(; i < s.length(); i++){
            char c = s.charAt(i);
            if(!Character.isDigit(c)){
                return getOutput(isPositive, res);
            }
            res = res*10 + (c-'0');
            if(isPositive && res > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if(!isPositive && -1 * res < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }
        return getOutput(isPositive, res);
    }

    public int getOutput(boolean isPositive, long res){
        return (isPositive)? (int)res: -1*(int)(res);
    }
}
```