# Pow(x, n)

- Time Complexity: O(log(N))
- Space Complexity: O(1)
  - N as n

```java
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

- Time Complexity: O(log(N))
- Space Complexity: O(1)
  - N as n

```java
class Solution {
    public double myPow(double x, int n) {
        if(n == 0 || x == 1){
            return 1;
        }
        if(n < 0){
            return 1/pow(x, n);
        }
        return pow(x, n);
    }

    public double pow(double x, int n){
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return x;
        }
        double y = pow(x, n/2);
        if(n%2 == 0){
            return y*y;
        }
        return y*y*x;
    }
}
```
