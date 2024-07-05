# Pascal's Triangle II

- Time Complexity: O(NR)
- Space Complexity: O(N)
  - N as length of res
  - R as rowIndex

```
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new LinkedList();
        while(rowIndex >= 0){
            res.add(0, 1);
            for(int i = 1; i+1 < res.size(); i++){
                res.set(i, res.get(i) + res.get(i+1));
            }
            rowIndex--;
        }
        return res;
    }
}
```
