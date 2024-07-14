# Average Salary Excluding the Minimum and Maximum Salary

# Lambda

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of salary

```java
class Solution {
    public double average(int[] salary) {
        int max = Arrays.stream(salary).max().getAsInt(),
            min = Arrays.stream(salary).min().getAsInt();
        return (double)(Arrays.stream(salary).sum() - max - min)/(salary.length-2);
    }
}
```

# Arrays

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of salary

```java
class Solution {
    public double average(int[] salary) {
        int max = Integer.MIN_VALUE,
            min = Integer.MAX_VALUE,
            sum = 0;
        for(int s: salary){
            max = Math.max(max, s);
            min = Math.min(min, s);
            sum += s;
        }
        return (double)(sum-min-max)/(salary.length-2);
    }
}
```
