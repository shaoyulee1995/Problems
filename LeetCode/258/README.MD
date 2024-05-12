# Add Digits
# Math
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as digits of num
```
class Solution {
    public int addDigits(int num) {
        while(num > 9){
            num = split(num);
        }
        return num;
    }
    public int split(int num){
        int res = 0;
        while(num != 0){
            res = res + num % 10;
            num /= 10;
        }
        return res;
    }
}
```