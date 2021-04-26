class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)){
            return "";
        }
        int gcdVal = gcd(str1.length(), str2.length());
        return str2.substring(0, gcdVal);
    }
    
    private int gcd(int p, int q){
        return (q==0)?p: gcd(q, p%q);
    }
}