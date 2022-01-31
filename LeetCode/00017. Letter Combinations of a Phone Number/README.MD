# Backtrack
* Time Complexity: O(3^M * 4^N)
* Space Complexity: O(M+N)
	* M as digits 2, 3, 4, 5, 6, 8
	* N as digits 7, 9
```
class Solution {
    List<String> list = new ArrayList();
    String[] keys = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0 || digits == null){
            return list;
        }
        letterCombinations(digits, 0);
        return list;
    }
    public void letterCombinations(String digits, int index){
        if(index == digits.length()){
            list.add(new String(sb.toString()));
            return;
        }
        String word = keys[digits.charAt(index)-'0'];
        for(int i = 0; i < word.length(); i++){
            sb.append(word.charAt(i));
            letterCombinations(digits, index+1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
```