# 2 Stacks
* Time Complexity: O(N+M)
* Space Complexity: O(N+M)
	* N as length of s
	* M as length of t
```
class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack(),
                         s2 = new Stack();
        for(char c: s.toCharArray()){
            if(c != '#'){
                s1.push(c);
            }else if(!s1.isEmpty()){
                s1.pop();
            }
        }
        for(char c: t.toCharArray()){
            if(c != '#'){
                s2.push(c);
            }else if(!s2.isEmpty()){
                s2.pop();
            }
        }
        if(s1.size() != s2.size()){
            return false;
        }
        while(!s1.isEmpty()){
            char c1 = s1.pop(),
                 c2 = s2.pop();
            if(c1 != c2){
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