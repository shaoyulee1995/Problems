# Binary Search
* Time Complexity: O(log(N))
* Space Complexity: O(1)
	* N as num
```
class Solution {
    public boolean isPerfectSquare(int num) {
        int left = 1, right = num;
        while(left <= right){
            int mid = left + (right-left)/2;
            int res = num/mid, remain = num%mid;
            if(res == mid && remain == 0){
                return true;
            }
            if(res > mid){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }
}
```