class Solution {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for(int i = 0; i < s.length(); i++){
            
            if(i + 2 < s.length() && s.charAt(i + 2) == '#'){
                index = 10 * (s.charAt(i) - 48) + (s.charAt(i+1) - 48);
                i+=2;
            }else{
                index = s.charAt(i) - 48;
                System.out.println("index else: " + index);
            }  
            sb.append((char) (index + 96));
        }
        return sb.toString();
    }
}