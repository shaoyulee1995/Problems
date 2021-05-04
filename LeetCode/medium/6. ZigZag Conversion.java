class Solution {
    public String convert(String s, int numRows) {
        char[] c = s.toCharArray();
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++){
            sb[i] = new StringBuilder();
        }
        
        int index = 0;
        while(index < c.length){
            for(int i = 0; i < sb.length && index < c.length; i++){
                sb[i].append(c[index++]);
            }
            for(int i = sb.length - 2; i > 0 && index < c.length; i--){
                sb[i].append(c[index++]);
            }
        }
        
        StringBuilder total = new StringBuilder();
        for(int i = 0; i <sb.length; i++){
            total.append(sb[i]);
        }
        return total.toString();
    }
}