# Reformat Date

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of date

```
class Solution {
    String[] months = {"0", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    public String reformatDate(String date) {
        String[] s = date.split("\\s+");
        StringBuilder sb = new StringBuilder();
        sb.append(s[2]).append("-");
        for(int i = 0; i < months.length; i++){
            if(months[i].equals(s[1])){
                if(i < 10){
                    sb.append("0");
                }
                sb.append(i);
            }
        }
        sb.append("-");
        sb.append(s[0].length() == 3 ? ("0" + s[0].substring(0, 1)) : s[0].substring(0, 2));
        return sb.toString();
    }
}
```
