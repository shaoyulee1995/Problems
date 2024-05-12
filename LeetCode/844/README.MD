# Backspace String Compare
# 2 Stacks
* Time Complexity: O(N+M)
* Space Complexity: O(N+M)
	* N as length of s
	* M as length of t
```
class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> x = new Stack(),
                         y = new Stack();
        for(char c: s.toCharArray()){
            if(c != '#'){
                x.push(c);
            }else if(c == '#' && !x.isEmpty()){
                x.pop();
            }
        }
        for(char c: t.toCharArray()){
            if(c != '#'){
                y.push(c);
            }else if(c == '#' && !y.isEmpty()){
                y.pop();
            }
        }
        if(x.size() != y.size()){
            return false;
        }
        while(!x.isEmpty()){
            if(x.pop() != y.pop()){
                return false;
            }
        }
        return true;
    }
}
```
# 1 Stack
* Time Complexity: O(N+M)
* Space Complexity: O(N+M)
	* N as length of s
	* M as length of t
```
class Solution {
    public boolean backspaceCompare(String s, String t) {
        return buildString(s).equals(buildString(t));
    }
    
    public String buildString(String s){
        Stack<Character> stack = new Stack();
        for(char c: s.toCharArray()){
            if(c != '#'){
                stack.push(c);
            }else if(c == '#' && !stack.isEmpty()){
                stack.pop();
            }
        }
        return String.valueOf(stack);
    }
}
```