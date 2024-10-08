# Number of Steps to Reduce a Number to Zero

- Time Complexity: O(logN)
- Space Complexity: O(1)
  - N as num

```java
class Solution {
    public int numberOfSteps(int num) {
        int step = 0;
        while(num != 0){
            if(num % 2 == 0){
                num /= 2;
            }else{
                num--;
            }
            step++;
        }
        return step;
    }
}
```

- Time Complexity: O(logN)
- Space Complexity: O(1)
  - N as num

```java
class Solution {
    public int numberOfSteps(int num) {
        int res = 0;
        while(num != 0){
            if((num & 1) == 1){
                num--;
            }else{
                num >>= 1;
            }
            res++;
        }
        return res;
    }
}
```
