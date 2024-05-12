# Count Primes
# Array
* Time Complexity: O(N<sup>2</sup>)
* Space Complexity: O(N)
    * N as n
```
class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int res = 0;
        for(int i = 2; i < n; i++){
            if(!notPrime[i]){
                res++;
                for(int j = 2; j*i < n; j++){
                    notPrime[i*j] = true;
                }
            }
        }
        return res;
    }
}
```