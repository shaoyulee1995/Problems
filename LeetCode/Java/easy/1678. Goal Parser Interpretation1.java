class Solution {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < command.length(); i++){
            char c = command.charAt(i);
            
            if(c=='G'){
                sb.append(c);;
            }else if(c=='(' && command.charAt(i+1)==')'){
                sb.append('o');
            }else if(c=='(' && command.charAt(i+1)=='a'){
                sb.append("al");
            }
        }
        return sb.toString();
    }
}