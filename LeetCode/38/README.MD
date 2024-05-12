# Count and Say
# Greedy
* Time Complexity: O(NW)
* Space Complexity: O(W)
	* N as n
    * W as length of W
```
class Solution {
    public String countAndSay(int n) {
        String res = "1";
        for(int i = 1; i < n; i++){
            res = countAndSay(res);
        }
        return res;
    }

    public String countAndSay(String word){
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char c = word.charAt(0);
        for(int i = 1; i < word.length(); i++){
            if(c == word.charAt(i)){
                count++;
            }else{
                sb.append(count).append(c);
                c = word.charAt(i);
                count = 1;
            }
        }
        sb.append(count).append(c);
        return sb.toString();
    }
}
```