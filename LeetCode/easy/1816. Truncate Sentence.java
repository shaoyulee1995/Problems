class Solution {
    public String truncateSentence(String s, int k) {
        String[] parse = s.split(" ");
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < k; i++){
            if(k == i + 1){
                sb.append(parse[i]);
                break;
            }
            sb.append(parse[i] + " ");
        }
        return sb.toString();
    }
}