# Count Substrings That Satisfy K-Constraint I

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of s

```java
class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int res = 0;
        for(int i = 0, j = 0, ones = 0, zeros = 0; j < s.length(); j++){
            char c = s.charAt(j);
            if(c == '0'){
                zeros++;
            }else{
                ones++;
            }
            while(zeros > k && ones > k){
                c = s.charAt(i++);
                if(c == '0'){
                    zeros--;
                }else{
                    ones--;
                }
            }
            res += j-i+1;
        }
        return res;
    }
}

```