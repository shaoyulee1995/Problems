# Slowest Key

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as lenght of releaseTimes

```
class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char res = keysPressed.charAt(0);
        int maxDuration = releaseTimes[0];
        for(int i = 1; i < releaseTimes.length; i++){
            if(maxDuration < releaseTimes[i] - releaseTimes[i-1]){
                res = keysPressed.charAt(i);
                maxDuration = releaseTimes[i] - releaseTimes[i-1];
            }else if(maxDuration == releaseTimes[i] - releaseTimes[i-1]){
                if(res < keysPressed.charAt(i)){
                    res = keysPressed.charAt(i);
                }
            }
        }
        return res;
    }
}
```
