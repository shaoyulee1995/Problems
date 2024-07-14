# Minimum String Length After Removing Substrings

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(1)
  - N as length of s

```java
class Solution {
    public int minLength(String s) {
        while(s.indexOf("AB") >= 0 || s.indexOf("CD") >= 0){
            if(s.indexOf("AB") >= 0){
                s = s.replace("AB", "");
            }else{
                s = s.replace("CD", zs"");
            }
        }
        return s.length();
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of s

```java
class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack();
        for(char c: s.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == 'A' && c == 'B'){
                stack.pop();
            }else if(!stack.isEmpty() && stack.peek() == 'C' && c == 'D'){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        return stack.size();
    }
}
```
