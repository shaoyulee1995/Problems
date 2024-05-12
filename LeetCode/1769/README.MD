# Minimum Number of Operations to Move All Balls to Each Box
# Array
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of boxes
```
class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] res = new int[n],
              L = new int[n],
              R = new int[n];
        int Rval = boxes.charAt(0)-'0';
        for(int i = 1; i < n; i++){
            int curVal = boxes.charAt(i)-'0';
            R[i] = R[i-1] + Rval;
            Rval += curVal;
        }
        int Lval = boxes.charAt(n-1)-'0';
        for(int i = n-2; i >= 0; i--){
            int curVal = boxes.charAt(i)-'0';
            L[i] = L[i+1] + Lval;
            Lval += curVal;
        }
        for(int i = 0; i < n; i++){
            res[i] = L[i] + R[i];
        }
        return res;
    }
}
```
# BF
* Time Complexity: O(N^2)
* Space Complexity: O(N)
	* N as length of boxes
```
class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(boxes.charAt(j) == '1'){
                    res[i] += Math.abs(i-j);
                }
            }
        }
        return res;
    }
}
```