# Queue Reconstruction by Height

# LinkedList

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of word

```java
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0]? a[1] - b[1]: b[0] - a[0]);
        LinkedList<int[]> res = new LinkedList();
        for(int[] p: people){
            res.add(p[1], p);
        }
        return res.toArray(int[][]:: new);
    }
}
```
