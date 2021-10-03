class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return new ArrayList();
        }
        String[] key = {"","", "abc","def",
                       "ghi","jkl","mno",
                       "pqrs","tuv","wxyz"};
        List<String> ans = new ArrayList();
        ans.add("");
        for(int i = 0; i < digits.length(); i++){
            ans = combine(ans, key[digits.charAt(i) - '0']);
        }
        return ans;
    }
    
    private List<String> combine(List<String> list, String key){
        List<String> res = new ArrayList();
        for(char c: key.toCharArray()){
            for(String s: list){
                res.add(s + c);
            }
        }
        return res;
    }
}