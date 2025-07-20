# Average Waiting Time

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of customers

```java
class Solution {
    public double averageWaitingTime(int[][] customers) {
        double wait = 0d,
               cur = 0d;
        for(int[] customer: customers){
            cur = Math.max(cur, 1d * customer[0]) + customer[1];
            wait += cur - customer[0];
        }
        return wait/customers.length;    
    }
}
```