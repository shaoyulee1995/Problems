class Solution {
    public String countAndSay(int n) {
        String ans = "1";
        while(n>1){
            ans = say(ans);
            n--;
        }
        return ans;
    }
    public String say(String input){
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int i = 0; i < input.length(); i++){
            if(i+1 == input.length() || input.charAt(i) != input.charAt(i+1)){
                sb.append(String.valueOf(++cnt));
                sb.append(input.charAt(i));
                cnt = 0;
            }else{
                cnt++;
            }
        }
        return sb.toString();
    }
}

