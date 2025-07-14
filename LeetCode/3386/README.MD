# Button with Longest Push Time

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of events

```java
class Solution {
    public int buttonWithLongestTime(int[][] events) {
        int buttonIndex = events[0][0],
            maxButtonDuration = events[0][1];
        for(int i = 1; i < events.length; i++){
            int currentButtonDuration = events[i][1] - events[i-1][1];
            if(currentButtonDuration > maxButtonDuration || (currentButtonDuration == maxButtonDuration && events[i][0] < buttonIndex)){
                maxButtonDuration = currentButtonDuration;
                buttonIndex = events[i][0];
            }
        }
        return buttonIndex;
    }
}
```