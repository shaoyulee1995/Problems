# Find the Winner of an Array Game

- Time Complexity: O(N)
- Space Complexity: O(1)

```java
class Solution {
    public int getWinner(int[] arr, int k) {
        int cur = arr[0], wins = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > cur){
                cur = arr[i];
                wins = 0;
            }
            if(++wins == k){
                break;
            }
        }
        return cur;
    }
}
```
