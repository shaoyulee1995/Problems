class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<Character>();
        int num = 0;
        for(char c: jewels.toCharArray()){
            set.add(c);
        }
        
        for(char c: stones.toCharArray()){
            if(set.contains(c)){
                num++;
            }
        }
        return num;  
    }
}