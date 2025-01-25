# Most Visited Sector in a Circular Track

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as Max(n, rounds.length)

```java
class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> res = new ArrayList();
        for(int i = rounds[0]; i <= rounds[rounds.length-1]; i++){
            res.add(i);
        }
        if(!res.isEmpty()){
            return res;
        }
        for(int i = 1; i <= rounds[rounds.length-1]; i++){
            res.add(i);
        }
        for(int i = rounds[0]; i <= n; i++){
            res.add(i);
        }
        return res;       
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as Max(n, rounds.length)
  
```java
class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> res = new ArrayList();
        int start = rounds[0],
            end = rounds[rounds.length-1];
        if(start <= end){
            for(int i = start; i <= end; i++){
                res.add(i);
            }
        }else{
            for(int i = 1; i <= end; i++){
                res.add(i);
            }
            for(int i = start; i <= n; i++){
                res.add(i);
            }
        }
        return res;
    }
}
```