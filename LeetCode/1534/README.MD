# Count Good Triplets

- Time Complexity: O(N)
- Space Complexity: O(1)

```
class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int i = 0,
            j = i + 1,
            k = j + 1,
            res = 0;
        while(i + 2 < arr.length){
            if(valid(arr, i, j, a)&&
               valid(arr, j, k, b)&&
               valid(arr, i, k, c)){
                res++;
            }
            if(k < arr.length){
                k++;
            }
            if(k == arr.length){
                j++;
                k = j+1;
            }
            if(j+1 == arr.length){
                i++;
                j = i+1;
                k = j+1;
            }
        }
        return res;
    }
    public boolean valid(int[] arr, int i, int j, int target){
        return Math.abs(arr[i] - arr[j]) <= target;
    }
}
```
