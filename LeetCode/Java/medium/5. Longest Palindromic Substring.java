class Solution {
    public String longestPalindrome(String s) {
        
        int start = 0, maxLength = 0;
        for(int i = 0; i < s.length(); i++){
            int len1 = MiddleExpansion(s,i,i), //if s is odd length
                len2 = MiddleExpansion(s,i,i+1); //if s is even length
            int len = Math.max(len1, len2);
            
            //update
            //from
                //aba
            //to    
                //aabbaa
            if(len > maxLength){
                maxLength = len;
                start = i - ((len-1) / 2);
            }
        }
        return s.substring(start, start+maxLength);
    }
    //length for palidrom
    public int MiddleExpansion(String s, int left, int right){
        if(s == null || left > right)
            return 0;
        // aabaa
        //l     r
        
        // aabbaa
        //l      r
        
        //break the loop when its out of bound so
        while(left <= right && left >= 0 && 
              right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }
}