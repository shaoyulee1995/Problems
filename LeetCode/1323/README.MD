# Maximum 69 Number

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of num

```java
class Solution {
    public int maximum69Number (int num) {
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        for(int i = 0; i< sb.length(); i++){
            if(sb.charAt(i) != '9'){
                sb.setCharAt(i, '9');
                return Integer.parseInt(sb.toString());
            }
        }
        return Integer.parseInt(sb.toString());
    }
}
```

# Char Array

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of num

```java
class Solution {
    public int maximum69Number (int num) {
        char[] res = String.valueOf(num).toCharArray();
        for(int i = 0; i < res.length; i++){
            if(res[i] != '9'){
                res[i] = '9';
                return Integer.parseInt(String.valueOf(res));
            }
        }
        return Integer.parseInt(String.valueOf(res));
    }
}
```
