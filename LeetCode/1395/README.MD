# Count Number of Teams

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(1)
  - N as length of rating

```java
class Solution {
    public int numTeams(int[] arr) {
        int res = 0, n = arr.length;
        for(int j = 1; j < n-1; j++){
            int L_inc = 0,
                L_dec = 0,
                R_inc = 0,
                R_dec = 0;
            for(int i = 0; i < j; i++){
                if(arr[i] < arr[j]){
                    L_inc++;
                }else{
                    L_dec++;
                }
            }
            for(int k = j+1; k < n; k++){
                if(arr[j] < arr[k]){
                    R_inc++;
                }else{
                    R_dec++;
                }
            }
            res += (L_inc * R_inc) + (L_dec * R_dec);
        }
        return res;
    }
}
```
