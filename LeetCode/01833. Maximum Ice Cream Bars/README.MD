# Sort
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of costs
```
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int res = 0;
        Arrays.sort(costs);
        for(int i = 0; i < costs.length; i++){
            int val = coins-costs[i];
            if(val < 0){
                break;
            }else{
                res++;
                coins -= costs[i];
            }
        }
        return res;
    }
}
```