# Count Operations to Obtain Zero

- Time Complexity: O(log(Min(num1, num2)))
- Space Complexity: O(1)
  - log(Min(num1, num2)) as the depth of the recursion

```java
class Solution {
    public int countOperations(int num1, int num2) {
        int res = 0;
        while(num1 != 0 && num2 != 0){
            if(num1 >= num2){
                num1 -= num2;
            }else{
                num2 -= num1;
            }
            res++;
        }
        return res;
    }
}
```

- Time Complexity: O(log(Min(num1, num2)))
- Space Complexity: O(1)
  - log(Min(num1, num2)) as the depth of the recursion

```java
class Solution {
    public int countOperations(int num1, int num2) {
        return num1*num2 == 0? 0: num1/num2 + countOperations(num2, num1%num2);
    }
}

```
