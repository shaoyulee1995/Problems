# HashMap
* Time Complexity: O(B)
* Space Complexity: O(N)
```
class Solution {
    HashMap<Integer, Integer> map;
    int M;
    Random r;
    public Solution(int n, int[] blacklist) {
        map = new HashMap();
        for(int b: blacklist){
            map.put(b, -1);
        }
        M = n - map.size();
        for(int b: blacklist){
            if(b < M){
                while(map.containsKey(n-1)){
                    n--;
                }
                map.put(b, n-1);
                n--;
            }
        }
        r = new Random();
    }
    public int pick() {
        int p = r.nextInt(M);
        if(map.containsKey(p)){            
            System.out.println(p + " " + map.get(p));
            return map.get(p);
        }
        return p;
    }
}
```
```
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
```