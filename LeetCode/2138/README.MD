# Divide a String Into Groups of Size k

# String

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of s

```
class Solution {
    public String[] divideString(String s, int k, char fill) {
        List<String> res = new ArrayList();
        for(int i = 0; i < s.length(); i += k){
            int length = s.substring(i, Math.min(i+k, s.length())).length();
            if(length == k){
                res.add(s.substring(i, i+k));
            }else if(length < k){
                StringBuilder sb = new StringBuilder(s.substring(i, i+length));
                for(int j = sb.length(); j < k; j++){
                    sb.append(fill);
                }
                res.add(sb.toString());
            }
        }
        return res.toArray(String[]:: new);
    }
}
```
