class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        int cntL = 0,
            cntR = 0;
        for(int i = 0, j = s.length() -1; i < j; i++, j--){
            cntL += set.contains(s.charAt(i))?1:0;
            cntR += set.contains(s.charAt(j))?1:0;
        }
        return cntL==cntR;
    }
}