# Hamming Distance
# Bit
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of Max(x, y)
```
class Solution {
    public int hammingDistance(int x, int y) {
        int res = 0;
        while(x != 0 || y != 0){
            int a = (x&1),
                b = (y&1);
            res += ((a^b) == 1)? 1: 0;
            x >>= 1;
            y >>= 1;
        }
        return res;
    }
}
```