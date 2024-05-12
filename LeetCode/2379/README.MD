# Minimum Recolors to Get K Consecutive Black Blocks
# String
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of blocks
```
class Solution {
    public int minimumRecolors(String blocks, int k) {
        int whiteBlock = 0,
            res = Integer.MAX_VALUE,
            i = 0,
            j = 0;
        while(j < k){
            if(blocks.charAt(j++)=='W'){
                whiteBlock++;
            }
        }
        while(j < blocks.length()){
            res = Math.min(res, whiteBlock);
            if(blocks.charAt(i++)=='W'){
                whiteBlock--;
            }
            if(blocks.charAt(j++)=='W'){
                whiteBlock++;
            }
        }
        res = Math.min(res, whiteBlock);
        return res;
    }
}
```