# Math
* Time Complexity: O(log(N))
* Space Complexity: O(1)
	* N as n
```
class Solution {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 1/x * myPow(1/x, -(n+1));
        }
        return (n%2 == 0)?myPow(x*x, n/2): x*myPow(x*x, n/2);
    }
}
```
# Math
* Time Complexity: O(log(N))
* Space Complexity: O(1)
	* N as n
```
class Solution {
    public double myPow(double x, int n) {
        if(x == 0 || x == 1){
            return x;
        }
        return (n < 0)? 1/pow(x, -n): pow(x, n);
    }
    public double pow(double x, int n){
        if(n == 0){
            return 1;
        }
        double y = pow(x, n/2);
        return (n % 2 == 0)? y*y: y*y*x;
    }
}
```