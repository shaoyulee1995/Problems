# Thousand Separator

# String

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as n

```
class Solution {
    public String thousandSeparator(int n) {
        if(n == 0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while(n != 0){
            if(sb.length() > 0 && cnt%3 == 0){
                sb.append(".");
            }
            sb.append(n%10);
            n /= 10;
            cnt++;
        }
        return sb.reverse().toString();
    }
}
```

# String

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as n

```
class Solution {
    public String thousandSeparator(int n) {
        String num = Integer.toString(n);
        StringBuilder sb = new StringBuilder();
        for(int i = num.length(); i > 0; i -= 3){
            if(sb.length() > 0){
                sb.insert(0, ".");
            }
            sb.insert(0, num.substring(Math.max(0, i-3), i));
        }
        return sb.toString();
    }
}
```
