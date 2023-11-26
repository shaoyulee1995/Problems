# Two Pointers
* Time Complexity: O(N<sup>2</sup>)
* Space Complexity: O(1)
	* N as length of prices
```
class Solution {
    public int[] finalPrices(int[] prices) {
        for(int i = 0; i+1 < prices.length; i++){
            for(int j = i+1; j < prices.length; j++){
                if(prices[j] <= prices[i]){
                    prices[i] -= prices[j];
                    break;
                }
            }
        }
        return prices;
    }
}
```
# Stack
* Time Complexity: O(N<sup>2</sup>)
* Space Complexity: O(N)
	* N as length of prices
```
class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack();
        for(int i = 0; i < prices.length; i++){
            while(!stack.isEmpty() && prices[stack.peek()] >= prices[i]){
                prices[stack.pop()] -= prices[i];
            }
            stack.push(i);
        }
        return prices;
    }
}
```