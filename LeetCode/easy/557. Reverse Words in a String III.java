class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");
        for(String word: words){
            sb.append(new StringBuilder(word).reverse().toString()+" ");
        }
        // sb.deleteCharAt(sb.length() - 1);
        // return sb.toString();
        
        return sb.toString().trim();
    }
}