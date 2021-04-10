class Solution {
    public String toLowerCase(String str) {
        char[] c = str.toCharArray();
        
        for(int i = 0; i < str.length(); i++){
            char cur = (char)(str.charAt(i) | (char)(32));
            c[i] = cur;
        }
        return new String(c);
    }
}