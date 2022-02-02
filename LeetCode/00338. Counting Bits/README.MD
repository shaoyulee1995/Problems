# Math
* Time Complexity: O(N)
* Space Complexity: O(N)
```
class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for(int i = 1; i <= n; i++){
            res[i] = res[i/2];
            if(i%2 == 1){
                res[i]++;
            }
        }
        return res;
    }
}
```