# Number of Employees Who Met the Target

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of hours

```java
class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int res = 0;
        for(int hour: hours){
            res += (hour >= target)? 1: 0;
        }
        return res;
    }
}
```

```java
class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        return (int)Arrays.stream(hours).filter(x -> x >= target).count();
    }
}
```
