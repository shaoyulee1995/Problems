class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1,
            j = b.length() - 1;
        int carry = 0;      
        while(i>=0 || j >= 0){
            int aVal = (i>=0)?(a.charAt(i)-'0'):0,
                bVal = (j>=0)?(b.charAt(j)-'0'):0;
            int sum = aVal + bVal + carry;
            carry = sum / 2;
            sb.append(String.valueOf(sum%2));
            i--;
            j--;
        }
        if(carry > 0){
            sb.append("1");
        }
        sb.reverse().toString();
        return sb.toString();
    }
}