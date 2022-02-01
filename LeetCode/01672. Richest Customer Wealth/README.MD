# Traverse
* Time Complexity: O(MN)
* Space Complexity: O(1)
	* M as length of accounts
	* N as length of accounts[0]
```
class Solution {
    public int maximumWealth(int[][] accounts) {
        int res = 0;
        for(int i = 0; i < accounts.length; i++){
            int money = 0;
            for(int j = 0; j < accounts[0].length; j++){
                money += accounts[i][j];
            }
            res = Math.max(res, money);
        }
        return res;
    }
}
```