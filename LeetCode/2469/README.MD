# Convert the Temperature

- Time Complexity: O(1)
- Space Complexity: O(1)

```java
class Solution {
    public double[] convertTemperature(double celsius) {
        return new double[]{celsius+273.15, celsius*1.8+32};
    }
}
```
