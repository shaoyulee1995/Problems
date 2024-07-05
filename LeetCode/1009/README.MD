# Complement of Base 10 Integer

- Time Complexity: O(logN)
- Space Complexity: O(1)
  - N as n

```
class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0){
            return 1;
        }
        int bit = 1,
            todo  = n;
        while(todo != 0){
            n ^= bit;
            bit <<= 1;
            todo >>= 1;
        }
        return n;
    }
}
```

- Time Complexity: O(logN)
- Space Complexity: O(1)
  - N as n

```
class Solution {
    public int bitwiseComplement(int n) {
        int allOnes = 1;
        while(allOnes < n){
            allOnes = allOnes*2+1;
        }
        return allOnes - n;
    }
}
```
