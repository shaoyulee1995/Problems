class Solution {
    public String countAndSay(int n) {
        String ans = "1";
        while(n>1){
            ans = say(ans);
            n--;
        }
        return ans;
    }
    public String say(String str){
        StringBuilder sb = new StringBuilder();
        char c = str.charAt(0);
        int cnt = 1;
        
        for(int i = 1; i < str.length(); i++){
            if(c == str.charAt(i)){
                cnt++;
            }else{
                sb.append(cnt);
                sb.append(c);
                c = str.charAt(i);
                cnt = 1;
            }
        }
        sb.append(cnt).append(c);
        return sb.toString();
    }
}