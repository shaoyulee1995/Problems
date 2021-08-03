# Stack
* Time Complexity: O(1)
* Space Complexity: O(N)

```
class FreqStack {
    HashMap<Integer, Integer> nums;
    HashMap<Integer, Stack<Integer>> freqs;
    int maxFreq;
    public FreqStack() {
        nums = new HashMap();
        freqs = new HashMap();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int freq = nums.getOrDefault(val, 0) + 1;
        nums.put(val, freq);
        freqs.putIfAbsent(freq, new Stack());
        freqs.get(freq).push(val);
        maxFreq = Math.max(freq, maxFreq);
    }
    
    public int pop() {
        Stack<Integer> stack = freqs.get(maxFreq);
        int val = stack.pop();
        int freq = nums.get(val) - 1;
        nums.put(val, freq);
        if(stack.isEmpty()){
            maxFreq--;
        }
        return val;
    }
}
```
```
/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
```