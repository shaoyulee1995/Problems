# Find Lucky Integer in an Array
# Counting Array
* Time Complexity: O(A)
* Space Complexity: O(1)
	* A as length of arr
```
class Solution {
    public int findLucky(int[] arr) {
        int[] cnt = new int[501];
        for(int a: arr){
            cnt[a]++;
        }
        for(int i = cnt.length-1; i >= 1; i--){
            if(cnt[i] == i){
                return i;
            }
        }
        return -1;
    }
}
```