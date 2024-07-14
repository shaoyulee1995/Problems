# Find Positive Integer Solution for a Given Equation

```
/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as 1000

```java
class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList();
        int x = 1,
            y = 1000;
        while(x <= 1000 && y >= 1){
            int val = customfunction.f(x,y);
            if(val == z){
                res.add(Arrays.asList(x,y));
                x++;
                y--;
            }else if(val < z){
                x++;
            }else{
                y--;
            }
        }
        return res;
    }
}
```
