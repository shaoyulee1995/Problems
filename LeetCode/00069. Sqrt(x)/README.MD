# Binary Search
* Time Complexity: O(log(N))
* Space Complexity: O(1)
```
class Solution {
    public int mySqrt(int x) {
        if(x < 2){
            return x;
        }
        int i = 1, j = x;
        while(i < j){
            int k = i + (j-i)/2;
            int val = x/k;
            if(val == k){
                return k;
            }
            if(k > val){
                j = k;
            }else{
                i = k+1;
            }
        }
        return i-1;
    }
}
```