# Binary Number with Alternating Bits

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of bits n

```
class Solution {
    public boolean hasAlternatingBits(int n) {
        String bits = Integer.toBinaryString(n);
        for(int i = 1; i < bits.length(); i++){
            if(bits.charAt(i) == bits.charAt(i-1)){
                return false;
            }
        }
        return true;
    }
}
```

- Time Complexity: O(log<sub>2</sub>N)
- Space Complexity: O(1)
  - N as n

```
class Solution {
    public boolean hasAlternatingBits(int n) {
        int bit = n%2;
        n >>= 1;
        while(n > 0){
            if(bit == n%2){
                return false;
            }
            bit = n%2;
            n >>= 1;
        }
        return true;
    }
}
```
