# Reconstruct Original Digits from English

- Time Complexity: O(N)
- Space Complexity: O(26)
  - N as length of s

```java
class Solution {
    public String originalDigits(String s) {
        int[] cnt = new int[26];
        for(char c: s.toCharArray()){
            cnt[c-'a']++;
        }
        int[] nums = new int[10];
        nums[0] = cnt['z'-'a'];
        nums[2] = cnt['w'-'a'];
        nums[4] = cnt['u'-'a'];
        nums[6] = cnt['x'-'a'];
        nums[8] = cnt['g'-'a'];
        nums[1] = cnt['o'-'a'] - nums[0] - nums[2] - nums[4];
        nums[3] = cnt['h'-'a'] - nums[8];
        nums[5] = cnt['f'-'a'] - nums[4];
        nums[7] = cnt['s'-'a'] - nums[6];
        nums[9] = cnt['i'-'a'] - nums[5] - nums[6] - nums[8];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10; i++){
            while(nums[i]-->0){
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
```
