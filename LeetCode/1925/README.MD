# Count Square Sum Triples

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as n

```
class Solution {
    public int countTriples(int n) {
        HashSet<Integer> set = new HashSet();
        for(int i = 1; i <= n; i++){
            set.add(i*i);
        }
        int res = 0;
        for(int aSquare: set){
            for(int bSquare: set){
                if(set.contains(aSquare+bSquare)){
                    res++;
                }
            }
        }
        return res;
    }
}
}
```
