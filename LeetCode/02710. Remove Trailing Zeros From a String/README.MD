# String
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of num
```
class Solution {
    public String removeTrailingZeros(String num) {
        for(int i = num.length()-1; i >= 0; i--){
            if(num.charAt(i) == '0'){
                continue;
            }
            return num.substring(0, i+1);
        }    
        return null;
    }
}
```