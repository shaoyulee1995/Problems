class Solution {
    public int minAddToMakeValid(String S) {
        int cnt=0;
        Stack<Character> stack = new Stack();
        for(char c: S.toCharArray()){
            if(c =='('){
                stack.add(')');
            }else if(stack.isEmpty() || stack.pop() != c){
                cnt++;
            }
        }
        if(!stack.isEmpty()){
            return stack.size() + cnt;
        }
        
        return cnt;
    }
}