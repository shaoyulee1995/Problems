class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        
        int n1 = num1.length() - 1,
            n2 = num2.length() - 1,
            carry = 0;
        while(n1 >= 0 || n2 >= 0){
            int digit1 = n1<0?0:num1.charAt(n1) - '0',
                digit2 = n2<0?0:num2.charAt(n2) - '0';
            
            int sum = carry + digit1 + digit2;
            carry = sum > 9? 1: 0;
            sb.append(sum % 10);
            n1--;
            n2--;
        }
        if(carry > 0){
            sb.append(1);
        }
        
        return sb.reverse().toString();
    }
}