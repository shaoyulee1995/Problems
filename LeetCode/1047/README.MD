# Remove All Adjacent Duplicates In String
# String
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as chars in String
```
class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            int sb_size = sb.length();
            if(sb_size > 0 && sb.charAt(sb_size - 1) == c){
                sb.deleteCharAt(sb_size-1);
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
```
# Stack
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as chars in String
```
class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack();
        for(char c: s.toCharArray()){
            if(!stack.isEmpty() && c == stack.peek()){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
```
