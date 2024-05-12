# Minimum Domino Rotations For Equal Row
# Array
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of tops
```
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] cntT = new int[7],
              cntB = new int[7],
              same = new int[7];
        int n = tops.length;
        for(int i = 0; i < n; i++){
            cntT[tops[i]]++;
            cntB[bottoms[i]]++;
            if(tops[i] == bottoms[i]){
                same[tops[i]]++;
            }
        }
        
        for(int i = 1; i < 7; i++){
            if(cntT[i] + cntB[i] - same[i] == n){
                return n - Math.max(cntT[i], cntB[i]);
            }
        }
        
        return -1;
    }
}
```