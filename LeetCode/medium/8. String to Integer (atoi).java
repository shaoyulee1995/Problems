class Solution {
    public int myAtoi(String s) {
        
        s = s.trim();
        if(s == null || s.length() == 0 ||s.equals("")){
            return 0;
        }
        char firstChar = s.charAt(0);
        int sign = 1, start = 0, end = s.length();
        long sum = 0;
        if(firstChar=='+'){
            sign = 1;
            start++;
        }else if(firstChar =='-'){
            sign = -1;
            start++;
        }
        for(int i = start; i < end; i++){
            if(!Character.isDigit(s.charAt(i))){
                return (int)(sign*sum);
            }
            sum = sum*10 + s.charAt(i)-'0';
            if(sign == 1 && Integer.MAX_VALUE < sum){
                return Integer.MAX_VALUE;
            }
            if(sign == -1 && Integer.MIN_VALUE > sum  * -1){
                return Integer.MIN_VALUE;
            }
        }
        return (int)(sign*sum);
    }
}