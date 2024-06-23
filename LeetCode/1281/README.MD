# Subtract the Product and Sum of Digits of an Integer

# Math

- Time Complexity: O(logN)
- Space Complexity: O(1)

```
class Solution {
    public int subtractProductAndSum(int n) {
        int sum = 0, product = 1;
        while(n > 0){
            int digit = n%10;
            sum+=digit;
            product *=digit;
            n /= 10;
        }
        return product - sum;
    }
}
```
