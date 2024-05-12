# Find Greatest Common Divisor of Array
# Array
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of nums
```
class Solution {
    public int findGCD(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt(),
            max = Arrays.stream(nums).max().getAsInt();
        return gcd(min, max);
    }

    public int gcd(int a, int b){
        return (b==0)? a: gcd(b, a%b);
    }
}   
```