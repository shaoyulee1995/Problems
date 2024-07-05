# Simplify Path

- Time Complexity: O(P)
- Space Complexity: O(P)
  - P as length of path

```java
class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack();
        String[] strs = path.split("/");
        for(String str: strs){
            if(str.equals("")){
                continue;
            }else if(str.equals(".")){
                continue;
            }else if(str.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.add(str);
            }
        }
        return "/" + String.join("/", stack);
    }
}
```
