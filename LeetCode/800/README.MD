# Similar RGB Color

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of color

```java
class Solution {
    public String similarRGB(String color) {
        String[] values = {"00", "11", "22", "33", "44", "55", "66", "77", 
                           "88", "99", "aa", "bb", "cc", "dd", "ee", "ff"};
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        String rgb = null;
        for(int i = 1; i < color.length(); i += 2){
            String hex = color.substring(i, i+2);
            int res = Integer.MAX_VALUE;
            if(hex.charAt(0) == hex.charAt(1)){
                sb.append(hex);
                continue;
            }
            for(String value: values){
                int diff = Math.abs(Integer.parseInt(hex, 16) - Integer.parseInt(value, 16));
                if(res > diff){
                    res = diff;
                    rgb = value;
                }
                if(res == 0){
                    break;
                }
            }
            sb.append(rgb);
        }
        return sb.toString();
    }
}
```
