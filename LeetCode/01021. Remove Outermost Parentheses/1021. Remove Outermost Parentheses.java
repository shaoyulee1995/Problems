class Solution {
    public String removeOuterParentheses(String S) {
        int opened = 0;
        StringBuilder sb = new StringBuilder();
        
        for(char c: S.toCharArray()){
            if(c =='(' && opened++ > 0){
                sb.append(c);
            }
            if(c ==')' && opened-- > 1){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}