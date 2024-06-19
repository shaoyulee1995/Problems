# Relative Sort Array

# TreeMap

- Time Complexity: O(Max(N,M))
- Space Complexity: O(N)
  - N as length of arr1
  - M as length of arr2

```
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        TreeMap<Integer, Integer> map = new TreeMap();
        for(int num: arr1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] res = new int[arr1.length];
        int idx = 0;
        for(int num: arr2){
            while(map.get(num) != 0){
                res[idx++] = num;
                map.put(num, map.get(num) - 1);
            }
        }

        while(map.size() > 0){
            int key = map.firstKey(),
                freq = map.get(key);
            for(int i = 0; i < freq; i++){
                res[idx++] = key;
            }
            map.remove(key);
        }

        return res;
    }
}
```
