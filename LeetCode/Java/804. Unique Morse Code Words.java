class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] alphabet = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        Set<String> set = new HashSet();
        
        for(String s: words){
            char[] c = s.toCharArray();
            String local = "";
            for(int i = 0; i < c.length; i++){
                local += alphabet[c[i]-'a'];
            }
            set.add(local);
        }
        return set.size();
    }
}