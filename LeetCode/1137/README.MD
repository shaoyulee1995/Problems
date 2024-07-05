# N-th Tribonacci Number

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of n

```
class Solution {
    public int tribonacci(int n) {
        if(n < 3){
            return n == 0? 0: 1;
        }
        int a = 0,
            b = 1,
            c = 1,
            res = 0;
        for(int i = 3; i <= n; i++){
            res = a + b + c;
            a = b;
            b = c;
            c = res;
        }
        return res;
    }
}
```
