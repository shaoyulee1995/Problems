# Array
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as n
```
class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        res[0] = 0;
        for(int i = 1; i < res.length; i++){
            res[i] = i;
            res[0] -= i;
        }
        return res;
    }
}
```