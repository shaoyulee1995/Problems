class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char c: s.toCharArray()){
            if(c =='(' || c =='[' || c=='{'){
                stack.add(c);
                continue;
            }
            if(stack.isEmpty()){
                return false;
            }
            if(c == '}'&& stack.pop() != '{'){
                return false;
            }
             
            if(c == ')'&& stack.pop() != '('){
                return false;
            }
            if(c == ']'&& stack.pop() != '['){
                return false;
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}