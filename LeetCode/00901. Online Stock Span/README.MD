# Stack
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of price
```
class StockSpanner {
    Stack<Integer> prices, freq;
    public StockSpanner() {
        prices = new Stack();
        freq = new Stack();
    }
    
    public int next(int price) {
        int cur_freq = 1;
        while(!prices.isEmpty() && prices.peek() <= price){
            cur_freq += freq.peek();
            prices.pop();
            freq.pop();
        }
        prices.add(price);
        freq.add(cur_freq);
        return cur_freq;
    }
}
```
```
/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
```