# Array
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of amount
```
class Solution {
    public int fillCups(int[] amount) {
        int res = 0,
            max = 0;
        for(int num: amount){
            res += num;
            max = Math.max(max, num);
        }
        return Math.max(max, (res+1)/2);
    }
}
```