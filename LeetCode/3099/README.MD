# Harshad Number

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as logX

```java
class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {`
        int tmp = x,
            sum = 0;
        while(tmp != 0){
            sum += tmp%10;
            tmp /= 10;
        }
        if(x%sum == 0){
            return sum;
        }
        return -1;
    }
}

```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as logX

```java
class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum = 0;
        for(int tmp = x; tmp != 0; tmp /= 10){
            sum += tmp%10;
        }
        return (x%sum == 0)? sum: -1;
    }
}
```
