# Counting Array
* Time Complexity: O(N)
* Space Complexity: O(26)
	* N as length of s
```
class Solution {
    public int minDeletions(String s) {
        int[] cnt = new int[26];
        HashSet<Integer> set = new HashSet();
        for(char c: s.toCharArray()){
            cnt[c-'a']++;
        }
        int res = 0;
        for(int i = 0; i < 26; i++){
            while(cnt[i] > 0 && !set.add(cnt[i])){
                cnt[i]--;
                res++;
            }
        }
        return res;
    }
}
```