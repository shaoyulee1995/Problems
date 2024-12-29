# Check Array Formation Through Concatenation
- Time Complexity: O(N)
- Space Complexity: O(NM)
  - N is the length of arr
  - M is the length of pieces

```java
class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        HashMap<Integer, int[]> map = new HashMap();
        for(int[] piece: pieces){
            map.put(piece[0], piece);
        }
        int idx = 0;
        while(idx < arr.length){
            if(!map.containsKey(arr[idx])){
                return false;
            }
            int[] targetValues = map.get(arr[idx]);
            for(int target: targetValues){
                if(target != arr[idx]){
                    return false;
                }
                idx++;
            }
        }
        return true;
    }
}
```