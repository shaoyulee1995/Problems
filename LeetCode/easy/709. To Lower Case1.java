class Solution {
    public String toLowerCase(String str) {
        if(str.length() == 0){
            return "";
        }
        String ans = "";
        for(char c: str.toCharArray()){
            ans += Character.toLowerCase(c);
        }
        return ans;
    }
}