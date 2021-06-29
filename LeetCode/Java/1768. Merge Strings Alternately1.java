class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        int index1 = 0, index2 = 0;
        
        String ans = "";
        while(index1 < word1.length() || index2 < word2.length()){
            
            char one = '\0', two ='\0';
            if(index1 < word1.length()){
                one = word1.charAt(index1);
                ans += one;
            }
            if(index2 < word2.length()){
                two = word2.charAt(index2);
                ans += two;
            }
            
            
            index1++;
            index2++;
        }
        
        return ans;
        
    }
}