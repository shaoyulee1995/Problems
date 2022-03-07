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
# Bit Operation
* Time Complexity: O(Nlog(N))
* Space Complexity: O(N)
```
class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for(int i = 1; i <= n; i++){
            res[i] = bits(i);
        }
        return res;
    }
    public int bits(int num){
        int cnt = 0;
        while(num != 0){
            cnt += (num & 1);
            num >>= 1;
        }
        return cnt;
    }
}
```