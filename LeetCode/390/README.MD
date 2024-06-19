# Elimination Game

# Math

- Time Complexity: O(log<sub>2</sub>N)
- Space Complexity: O(1)
  - N as n

```
class Solution {
    public int lastRemaining(int n) {
        boolean left = true;
        int remain = n,
            step = 1,
            head = 1;
        while(remain > 1){
            if(left || remain % 2 == 1){
                head = head + step;
            }
            remain = remain/2;
            step *= 2;
            left = !left;
        }
        return head;
    }
}
```
