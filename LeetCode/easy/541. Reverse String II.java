class Solution {
    public String reverseStr(String s, int k) {
        char[] c = s.toCharArray();
        
        for(int i = 0; i < s.length(); i+= 2*k){
            int start = i,
                end = Math.min(s.length() - 1, i+k-1);
            
            while(start < end){
                char temp = c[start];
                c[start] = c[end];
                c[end] = temp;
                start++;end--;
            }
        }
        return new String(c);
    }
}