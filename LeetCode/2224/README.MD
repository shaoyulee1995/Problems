# Minimum Number of Operations to Convert Time

- Time Complexity: O(C)
- Space Complexity: O(1)
  - S as length of current

```
class Solution {
    public int convertTime(String current, String correct) {
        int start = getSeconds(current),
            end = getSeconds(correct),
            res = 0;
        while(start < end){
            int diff = end - start;
            if(diff >= 60){
                start += 60;
            }else if(diff >= 15){
                start += 15;
            }else if(diff >= 5){
                start += 5;
            }else if(diff >= 1){
                start += 1;
            }
            res++;
        }
        return res;
    }

    public int getSeconds(String time){
        return Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
    }
}
```
