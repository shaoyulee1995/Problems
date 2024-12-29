# A Number Is Same After Two Reversals

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N is the number of digits in num

```java
class Solution {
    public boolean isSameAfterReversals(int num) {
        if(num == 0){
            return true;
        }
        StringBuilder sb = new StringBuilder();
        while(num != 0){
            sb.append(num%10);
            num /= 10;
        }
        return sb.charAt(0) != '0';
    }
}
```

- Time Complexity: O(1)
- Space Complexity: O(1)

```java
class Solution {
    public boolean isSameAfterReversals(int num) {
        return num == 0 || num % 10 > 0;
    }
}
```
