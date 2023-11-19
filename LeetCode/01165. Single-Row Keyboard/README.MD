# Counting Array
* Time Complexity: O(Max(K, W))
* Space Complexity: O(26)
	* K as length of keyboard
	* W as length of word
```
class Solution {
    public int calculateTime(String keyboard, String word) {
        int res = 0,
            prev = 0;
        int[] cnt = new int[26];
        for(int i = 0; i < keyboard.length(); i++){
            cnt[keyboard.charAt(i)-'a'] = i;
        }
        for(char c: word.toCharArray()){
            res += Math.abs(prev - cnt[c-'a']);
            prev = cnt[c-'a'];
        }
        return res;
    }
}
```