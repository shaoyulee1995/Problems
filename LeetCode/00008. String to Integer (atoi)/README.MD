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
        int start = 0;
        long res = 0;
        if(s.charAt(0) == '-'){
            isPositive = false;
            start++;
        }else if(s.charAt(0) == '+'){
            start++;
        }
        for(int i = start; i < s.length(); i++){
            char c = s.charAt(i);
            if(!Character.isDigit(c)){
                return produceOutput(isPositive, res);
            }
            res = res*10 + c - '0';
            if(isPositive && res > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if(!isPositive && -1 * res < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }
        return produceOutput(isPositive, res);
    }

    public int produceOutput(boolean isPositive, long res){
        if(isPositive){
            return (int)res;
        }
        return (int)(-1*res);
    }
}
```