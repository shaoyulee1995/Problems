# Prime Number of Set Bits in Binary Representation

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as range between left and right

```
class Solution {
    HashSet<Integer> primes = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19));
    public int countPrimeSetBits(int left, int right) {
        int res = 0;
        for(int i = left; i <= right; i++){O(Nn)
            res += isPrime(i)? 1: 0;
        }
        return res;
    }

    public boolean isPrime(int num){O(n)
        int bits = 0;
        for(int i = num; i > 0; i >>= 1){
            bits += i&1;
        }
        return primes.contains(bits);
    }
}
```
