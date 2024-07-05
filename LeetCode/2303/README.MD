# Calculate Amount Paid in Taxes

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of brackets

```
class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double tax = 0;
        int prev = 0;
        for(int[] bracket: brackets){
            int upper = bracket[0],
                tax_rate = bracket[1];
            if(income >= upper){
                tax += (upper - prev) * tax_rate/100d;
                prev = upper;
            }else{
                tax += (income - prev) * tax_rate/100d;
                return tax;
            }
        }
        return tax;
    }

}
```
