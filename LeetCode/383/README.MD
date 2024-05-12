# Ransom Note
# Array
* Time Complexity: O(Max(R, M))
* Space Complexity: O(1)
	* R as length of ransomNote
	* M as length of magazine
```
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[26];
        for(char c: magazine.toCharArray()){
            cnt[c-'a']++;
        }
        for(char c: ransomNote.toCharArray()){
            cnt[c-'a']--;
            if(cnt[c-'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
```