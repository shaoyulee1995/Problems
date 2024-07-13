# Removing Stars From a String

- Time Complexity: O(N)
- Space Complexity: O(N)
    - N as length of s

```java
class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack();
        for(char c: s.toCharArray()){
            if(c == '*'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(c);
            }
        }
        return stack.stream().map(x -> x.toString()).collect(Collectors.joining(""));
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
    - N as length of s
```java
class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            if(c == '*'){
                sb.setLength(sb.length()-1);
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
```