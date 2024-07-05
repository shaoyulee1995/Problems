# Integer Replacement

- Time Complexity: O(log<sub>2</sub>N)
- Space Complexity: O(N)
  - N as n

```
class Solution {
    public int integerReplacement(int n) {
        Queue<Long> queue = new LinkedList();
        HashSet<Long> seen = new HashSet();
        queue.add((long)n);
        seen.add((long)n);
        int res = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Long node = queue.poll();
                if(node == 1){
                    return res;
                }
                if(node%2 == 0 && !seen.contains(node/2)){
                    queue.add(node/2);
                    seen.add(node/2);
                }else{
                    if(!seen.contains(node+1)){
                        queue.add(node+1);
                        seen.add(node+1);
                    }
                    if(!seen.contains(node-1)){
                        queue.add(node-1);
                        seen.add(node-1);
                    }
                }
            }
            res++;
        }
        return res;
    }
}
```
