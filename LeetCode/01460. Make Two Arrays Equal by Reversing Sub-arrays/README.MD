# Sorting
* Time Complexity: O(Nlog(N))
* Space Complexity: O(1)
```
class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != target[i]){
                return false;
            }
        }
        return true;
    }
}
```