# Palindrome Permutation
# String
* Time Complexity: O(N)
* Space Complexity: O(1)
    * N as length of s
```
class Solution {
    public boolean canPermutePalindrome(String s) {
        char[] cnt = new char[26];
        for(char c: s.toCharArray()){
            cnt[c-'a']++;
        }
        int count = 0;
        for(int i = 0; i < 26; i++){
            count += cnt[i]%2;
        }
        return count <= 1;
    }
}
```