# Kids With the Greatest Number of Candies

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N sa length of candies

```java
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().getAsInt();
        List<Boolean> res = new ArrayList();
        for(int candy: candies){
            res.add((candy+extraCandies >= max));
        }
        return res;
    }
}
```
