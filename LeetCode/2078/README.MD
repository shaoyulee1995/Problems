# Two Furthest Houses With Different Colors

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of colors

```
class Solution {
    public int maxDistance(int[] colors) {
        HashMap<Integer, Integer> firstHouse = new HashMap(),
                                  lastHouse = new HashMap();
        for(int i = 0, j = colors.length-1; i < colors.length;j--, i++){
            firstHouse.putIfAbsent(colors[i], i);
            lastHouse.putIfAbsent(colors[j], j);
        }

        int res = 0;
        for(Integer firstOccurance: firstHouse.keySet()){
            for(Integer lastOccurance: lastHouse.keySet()){
                if(firstOccurance != lastOccurance){
                    res = Math.max(res, lastHouse.get(lastOccurance) - firstHouse.get(firstOccurance));
                }
            }
        }
        return res;
    }
}
```

# Arrah

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of colors

```
class Solution {
    public int maxDistance(int[] colors) {
        int i = 0,
            j = colors.length-1;
        while(colors[0] == colors[j]){
            j--;
        }
        while(colors[colors.length-1] == colors[i]){
            i++;
        }
        return Math.max(colors.length-1-i, j);
    }
}
```
