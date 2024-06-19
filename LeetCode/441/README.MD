# Arranging Coins

# Binary Search

- Time Complexity: O(logN)
- Space Complexity: O(1)
  - N as length of colors

```
class Solution {
    public int arrangeCoins(int n) {
        long i = 0,
             j = n,
             sum = 0;
        while(i <= j){
            long k = i + (j-i)/2;
            sum = k*(k+1)/2;
            if(sum == n){
                return (int)k;
            }
            if(sum > n){
                j = k-1;
            }else{
                i = k+1;
            }
        }
        return (int)j;
    }
}
```
