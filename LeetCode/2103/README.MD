# Rings and Rods

# Counting Array

- Time Complexity: O(N)
- Space Complexity: O(10)
  - N as length of rings

```
class Solution {
    public int countPoints(String rings) {
        int[] R = new int[10],
              G = new int[10],
              B = new int[10];
        for(int i = 0; i < rings.length(); i+=2){
            char c = rings.charAt(i);
            int num = rings.charAt(i+1)-'0';
            if(c == 'R'){
                R[num]++;
            }else if(c == 'G'){
                G[num]++;
            }else if(c == 'B'){
                B[num]++;
            }
        }
        int res = 0;
        for(int i = 0; i < 10; i++){
            if(R[i] > 0 && G[i] > 0 && B[i] > 0){
                res++;
            }
        }
        return res;
    }
}
```

# HashMap

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of rings

```
class Solution {
    public int countPoints(String rings) {
        HashMap<Integer, HashSet<Character>> map = new HashMap();
        for(int i = 0; i < rings.length(); i+=2){
            char color = rings.charAt(i);
            int idx = rings.charAt(i+1);
            map.put(idx, map.getOrDefault(idx, new HashSet()));
            map.get(idx).add(color);
        }
        int res = 0;
        for(Map.Entry<Integer, HashSet<Character>> entry: map.entrySet()){
            if(entry.getValue().size() == 3){
                res++;
            }
        }
        return res;
    }
}
```
