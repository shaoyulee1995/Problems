# Number Complement
# Bit Manipulation
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of num in bits
```
class Solution {
public:
    int findComplement(int num) {
        int ones = 0;
        while(ones < num){
            ones = (ones << 1) | 1;
        }
        return ones - num;
    }
}
```