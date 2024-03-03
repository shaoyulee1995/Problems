# String
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of colors
```
class Solution {
    public boolean winnerOfGame(String colors) {
        int alice = 0,  
            bob = 0;
        for(int i = 1; i+1 < colors.length(); i++){
            if(colors.charAt(i) == colors.charAt(i-1) && colors.charAt(i) == colors.charAt(i+1)){
                if(colors.charAt(i) == 'A'){
                    alice++;
                }else{
                    bob++;
                }
            }
        }
        return alice > bob;
    }
}
```