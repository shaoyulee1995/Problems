# License Key Formatting

# Traverse reversely

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of s

```java
class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) =='-'){
                continue;
            }
            sb.append((sb.length()%(k+1) == k)?"-":"");
            sb.append(s.charAt(i));
        }
        return sb.reverse().toString().toUpperCase();
    }
}
```

# StringBuilder

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of s

```java
class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int val = k;
        for(int i = s.length() - 1; i >= 0; i--, val--){
            if(s.charAt(i) == '-'){
                val += 1;
                continue;
            }
            if(val == 0){
                val = k;
                sb.append('-');
            }
            char c = Character.toUpperCase(s.charAt(i));
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}
```
