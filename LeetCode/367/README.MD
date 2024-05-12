# Valid Perfect Square
# Binary Search
* Time Complexity: O(log(N))
* Space Complexity: O(1)
	* N as num
```
class Solution {
    public boolean isPerfectSquare(int num) {
        int i = 1,
            j = num;
        while(i <= j){
            int k = i + (j-i)/2,
                val = num/k,
                remain = num%k;
            if(k == val && remain == 0){
                return true;
            }
            if(k > val){
                j = k-1;
            }else{
                i = k+1;
            }
        }
        return false;
    }
}
```