# Number of Divisible Substrings

# String

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(1)
  - N as length of nums

```
class Solution {
    public int countDivisibleSubstrings(String word) {
        String[] digits = {"", "ab","cde", "fgh", "ijk", "lmn", "opq", "rst", "uvw", "xyz"};
        int[] map = new int[26];
        for(int i = 1; i < digits.length; i++){
            for(char c: digits[i].toCharArray()){
                map[c-'a'] = i;
            }
        }
        int res = 0;

        for(int i = 0; i < word.length(); i++){
            int total = 0;
            for(int j = i; j < word.length (); j++){
                total += map[word.charAt(j)-'a'];
                res += total%(j-i+1) == 0? 1: 0;
            }
        }
        return res;
    }
}

```
