# Construct the Rectangle

- Time Complexity: O(A)
- Space Complexity: O(1)
  - A as length of area

```
class Solution {
    public int[] constructRectangle(int area) {
        int L = area,
            W = 1;
        int[] res = new int[2];
        while(L >= W){
            if(area == L * W){
                res = new int[]{L, W};
            }
            W++;
            L = area/W;
        }
        return res;
    }
}
```

- Time Complexity: O(A)
- Space Complexity: O(1)
  - A as length of area

```
class Solution {
    public int[] constructRectangle(int area) {
        int W = (int)Math.sqrt(area);
        while(area%W != 0){
            W--;
        }
        return new int[]{area/W, W};
    }
}
```
