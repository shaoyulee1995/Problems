# Letter Combinations of a Phone Number
# Backtrack
* Time Complexity: O(3^M * 4^N)
* Space Complexity: O(M+N)
	* M as digits 2, 3, 4, 5, 6, 8
	* N as digits 7, 9
```
class Solution {
    String[] numbers = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> res;
    StringBuilder sb;
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0 || digits == null){
            return new ArrayList();
        }
        res = new ArrayList();
        sb = new StringBuilder();
        dfs(digits, 0);
        return res;
    }
    public void dfs(String digits, int idx){
        if(idx == digits.length()){
            res.add(sb.toString());
            return;
        }
        String keyString = numbers[digits.charAt(idx)-'0'];
        for(int i = 0; i< keyString.length(); i++){
            sb.append(keyString.charAt(i));
            dfs(digits, idx+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
```
# DFS
* Time Complexity: O(MAX(3^M,4^N))
* Space Complexity: O(M+N)
	* M as digits 2, 3, 4, 5, 6, 8
	* N as digits 7, 9
```
class Solution {
    String[] numbers = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> res;
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0 || digits == null){
            return new ArrayList();
        }
        res = new ArrayList();
        res.add("");
        for(char c: digits.toCharArray()){
            res = dfs(res, numbers[c-'0']);
        }
        return res;
    }

    public List<String> dfs(List<String> possibleList, String keyPressString){
        List<String> res = new ArrayList();
        for(char c: keyPressString.toCharArray()){
            for(String curString: possibleList){
                res.add(curString+c);
            }
        }
        return res;
    }
}
```