# Number Of Rectangles That Can Form The Largest Square

- Time Complexity: O(N)
- Space Complexity: O(1)

```
class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int res = 0,
            maxL = 0;
        for(int[] rectangle: rectangles){
            int val = Math.min(rectangle[0], rectangle[1]);
            if(val > maxL){
                maxL = val;
                res = 1;
            }else if(maxL == val){
                res++;
            }
        }
        return res;
    }
}
```
