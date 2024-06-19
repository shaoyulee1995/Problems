# Largest Time for Given Digits

# Brutal Force

- Time Complexity: O(N<sup>3</sup>)
- Space Complexity: O(1)
  - N as length of arr

```
class Solution {
    public String largestTimeFromDigits(int[] arr) {
        String res = "";
        int n = arr.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    if(i == j || j == k || i == k){
                        continue;
                    }
                    int l = 6 - i - j - k;
                    String h = "" + arr[i] + arr[j],
                           m = "" + arr[k] + arr[l],
                           t = h + ":" + m;
                    if(h.compareTo("24") < 0 && m.compareTo("60") < 0 && res.compareTo(t) < 0){
                        res = t;
                    }
                }
            }
        }
        return res;
    }
}
```
