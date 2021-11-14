# Math
## Solution 1
* Time Complexity: O(log(N))
* Space Complexity: O(1)
```
class Solution {
    public int numberOfMatches(int n) {
        int cnt = 0;
        while(n>1){
            cnt += (n%2==1)? n/2 + 1: n/2;
            n/=2;
        }
        return cnt;
    }
}
```

## Solution 2
* Time Complexity: O(1)
* Space Complexity: O(1)
```
class Solution {
    public int numberOfMatches(int n) {
        return n - 1;
    }
}
```