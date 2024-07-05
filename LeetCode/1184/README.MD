# Distance Between Bus Stops

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of distance

```
class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        return Math.min(getDistance(distance, start, destination), getDistance(distance, destination, start));
    }
    public int getDistance(int[] distance, int start, int destination){
        int res = 0;
        for(int i = start; i != destination; i = (i+1) % distance.length){
            res += distance[i];
        }
        return res;
    }
}
```
