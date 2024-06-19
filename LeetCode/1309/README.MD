# Decrypt String from Alphabet to Integer Mapping

# Forward

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of s

```
class Solution {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0, index = 0; i < s.length();){
            if(i + 2 < s.length() && s.charAt(i + 2) == '#'){
                index = Integer.parseInt(s.substring(i, i+2))-1;
                i+=3;
            }else{
                index = s.charAt(i)-'0'-1;
				i++;
            }
            char c = (char)(index+'a');
            sb.append(c);
        }
        return sb.toString();
    }
}
```

# Backward

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of s

```
class Solution {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length()-1,
            val;
        while(i >= 0){
            char c = s.charAt(i);
            if(c == '#'){
                val = Integer.parseInt(s.substring(i-2, i))-1;
                i -= 3;
            }else{
                val = Integer.parseInt(String.valueOf(c))-1;
                i--;
            }
            c = (char)('a'+val);
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}
```
