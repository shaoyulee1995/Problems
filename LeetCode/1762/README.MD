# Buildings With an Ocean View

# Array

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as number of nodes in tree

```
class Solution {
    public int[] findBuildings(int[] heights) {
        ArrayList<Integer> list = new ArrayList();
        int max = 0;
        for(int i = heights.length - 1; i >= 0; i--){
            if(max >= heights[i]){
                continue;
            }
            max = heights[i];
            list.add(i);
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(list.size()-1-i);
        }
        return res;
    }
}
}
```
