# Count Tested Devices After Test Operations

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of batteryPercentages

```java
class Solution {
    public int countTestedDevices(int[] batteryPercentages) {
        int res = 0,
            decrement = 0;
        for(int batteryPercentage: batteryPercentages){
            int cur = batteryPercentage - decrement;
            if(cur > 0){
                res++;
                decrement++;
            }
        }
        return res;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of batteryPercentages

```java
class Solution {
    public int countTestedDevices(int[] batteryPercentages) {
        int k = 0;
        for(int batteryPercentage: batteryPercentages){
            if(batteryPercentage > k){
                k++;
            }
        }
        return k;
    }
}
```
