class Solution {
    public String truncateSentence(String s, int k) {
        String ans = "";
        int cntSpace = 0;
        for(char c: s.toCharArray()){
            if(c == ' '){
                cntSpace++;
            }
            if(cntSpace == k){
                break;
            }
            ans += String.valueOf(c);
        }
        return ans;
    }
}