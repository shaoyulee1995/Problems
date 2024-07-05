# Pascal's Triangle

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(N)
  - N as numRows

```
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new LinkedList();
        List<Integer> row = new LinkedList();
        for(int i = 0; i < numRows; i++){
            row.add(0, 1);
            for(int j = 1; j + 1 < row.size(); j++){
                row.set(j, row.get(j) + row.get(j+1));
            }
            rows.add(new ArrayList(row));
        }
        return rows;
    }
}
```
