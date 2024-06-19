# Check if Number Has Equal Digit Count and Digit Value

# Counting

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of num

```
class Solution {
    public boolean digitCount(String num) {
        int[] cnt = new int[10];
        for(char c: num.toCharArray()){
            cnt[c-'0']++;
        }
        for(int i = 0; i < num.length(); i++){
            int digit = num.charAt(i)-'0';
            if(cnt[i] != digit){
                return false;
            }
        }
        return true;
    }
}
```
