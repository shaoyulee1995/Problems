# Apple Redistribution into Boxes

- Time Complexity: O(ClogC)
- Space Complexity: O(1)
  - C as lenght of capacity

```java
class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = Arrays.stream(apple).sum();
        Arrays.sort(capacity);
        int i = capacity.length-1;
        for(; i >= 0 && sum > 0; i--){
            sum -= capacity[i];
        }
        return capacity.length-i-1;
    }
}
```
