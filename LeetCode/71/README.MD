# Simplify Path

- Time Complexity: O(P)
- Space Complexity: O(P)
  - P as length of path

```java
class Solution {
    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        Stack<String> stack = new Stack();
        for(String str: strs){
            if(str.length() == 0 || str.equals(".")){
                continue;
            }else if(str.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(str);
            }
        }
        return "/"+ String.join("/", stack);
    }
}
```
