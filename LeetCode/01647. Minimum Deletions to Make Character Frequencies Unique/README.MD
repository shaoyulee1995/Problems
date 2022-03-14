# Counting Array
* Time Complexity: O(N)
* Space Complexity: O(26)
	* N as length of s
```
class Solution {
    public int minDeletions(String s) {
        int[] cnt = new int[26];
        for(char c: s.toCharArray()){
            cnt[c-'a']++;
        }
        HashSet<Integer> set = new HashSet();
        int moves = 0;
        for(int i = 0; i < 26; i++){
            if(cnt[i] == 0){
                continue;
            }
            while(set.contains(cnt[i])){
                cnt[i]--;
                moves++;
            }
            if(cnt[i] > 0){
                set.add(cnt[i]);
            }
        }
        return moves;
    }
}
```