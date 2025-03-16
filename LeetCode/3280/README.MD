# Convert Date to Binary

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as the length of the date string

```java
class Solution {
    public String convertDateToBinary(String date) {
        StringBuilder sb = new StringBuilder();
        String[] strs = date.split("-");
        for(int i = 0; i < strs.length; i++){
            sb.append(Integer.toBinaryString(Integer.parseInt(strs[i])));
            if(i != strs.length-1){
                sb.append("-");
            }
        }
        return sb.toString();
    }
}
```