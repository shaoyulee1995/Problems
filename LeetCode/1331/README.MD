# Rank Transform of an Array

# Array

- Time Complexity: O(NlogN)
- Space Complexity: O(N)
  - N as length of arr

```
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] clone = arr.clone();
        Arrays.sort(clone);
        HashMap<Integer, Integer> map = new HashMap();
        for(int a: clone){
            map.putIfAbsent(a, map.size() + 1);
        }
        for(int i = 0; i < arr.length; i++){
            clone[i] = map.get(arr[i]);
        }
        return clone;
    }
}
```
