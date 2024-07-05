# Delete Columns to Make Sorted

- Time Complexity: O(CR)
- Space Complexity: O(1)
  - C as length of cols
  - R as length of rows

```
class Solution {
    public int minDeletionSize(String[] strs) {
        int len = strs[0].length(),
            res = 0;
        for(int col = 0; col < len; col++){
            for(int row = 1; row < strs.length; row++){
                if(strs[row].charAt(col) < strs[row-1].charAt(col)){
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
```
