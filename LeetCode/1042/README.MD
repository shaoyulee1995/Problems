# Flower Planting With No Adjacent

- Time Complexity: O(NP)
- Space Complexity: O(P)
  - P as length of paths
  - N as n

```
class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap();
        for(int i = 0; i < n; i++){
            map.put(i, new HashSet());
        }
        for(int[] path: paths){
            int a = path[0] - 1,
                b = path[1] - 1;
            map.get(a).add(b);
            map.get(b).add(a);
        }
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            int[] color = new int[5];
            for(int num: map.get(i)){
                color[res[num]] = 1;
            }
            for(int c = 4; c >= 1; c--){
                if(color[c] != 1){
                    res[i] = c;
                }
            }
        }
        return res;
    }
}
```
