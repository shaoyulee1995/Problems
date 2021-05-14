class Solution {
    public String replaceDigits(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= '0' && c <= '9' && i - 1 >= 0){
                char insert = (char)(s.charAt(i-1) +( c -'0'));
                sb.append(insert);
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}