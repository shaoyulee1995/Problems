# String
* Time Complexity: O(N<sup>2</sup>)
* Space Complexity: O(1)
	* N as length of number
```
class Solution {
    public String removeDigit(String number, char digit) {
        for(int i = 1; i < number.length(); i++){
            if(number.charAt(i-1) == digit && number.charAt(i) > number.charAt(i-1)){
                return number.substring(0, i-1) + number.substring(i);
            }
        }
        int lastIndex = number.lastIndexOf(digit);
        return number.substring(0, lastIndex) + number.substring(lastIndex+1);
    }
}
```