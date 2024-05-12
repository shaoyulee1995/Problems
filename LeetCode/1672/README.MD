# Richest Customer Wealth
# Traverse
* Time Complexity: O(AN)
* Space Complexity: O(1)
	* A as length of accounts
	* N as length of accounts[0]
```
class Solution {
    public int maximumWealth(int[][] accounts) {
        int res = 0;
        for(int[] account: accounts){
            res = Math.max(res, Arrays.stream(account).sum());
        }
        return res;
    }
}
```