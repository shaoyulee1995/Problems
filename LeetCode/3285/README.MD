# Find Indices of Stable Mountains

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of height

```java
class Solution {
    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> res = new ArrayList();
        for(int i = 1; i < height.length; i++){
            if(height[i-1] > threshold){
                res.add(i);
            }
        }
        return res;
    }
}
```