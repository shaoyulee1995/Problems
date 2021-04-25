class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int[] p = read(pattern);
        List<String> ans = new ArrayList();
        for(String word: words){
            if(Arrays.equals(p, read(word))){
                ans.add(word);
            }
        }
        System.gc();
        return ans;
    }
    private int[] read(String s){
        HashMap<Character, Integer> map = new HashMap();
        int n = s.length();
        int[] res = new int[n];
        for(int i = 0; i < s.length(); i++){
            map.putIfAbsent(s.charAt(i), map.size());
            res[i] = map.get(s.charAt(i));
        }
        return res;
    }
}