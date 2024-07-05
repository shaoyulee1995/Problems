# Queries on Number of Points Inside a Circle

- Time Complexity: O(QP)
- Space Complexity: O(Q)
  - Q as length of queries
  - P as length of points

```
class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];
        int i = 0;
        for(int[] query: queries){
            int x = query[0],
                y = query[1],
                r = query[2],
                cnt = 0;
            for(int[] point: points){
                if(valid(point, x, y, r)){
                   cnt++;
                }
            }
            res[i++] = cnt;
        }
        return res;
    }
    public boolean valid(int[] point, int x, int y, int r){
        int x1 = point[0],
            y1 = point[1];
        return (int)Math.pow(Math.abs(x-x1), 2) + (int)Math.pow(Math.abs(y-y1), 2) <= (int)Math.pow(r, 2);
    }
}
```
