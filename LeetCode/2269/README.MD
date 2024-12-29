# Find All People With Secret

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as the length of num

```java
class Solution {
    public int divisorSubstrings(int num, int k) {
        int res = 0;
        String v = String.valueOf(num);
        for(int i = 0; i+k <= v.length(); i++){
            int x = Integer.parseInt(v.substring(i, i+k));
            if(x == 0){
                continue;
            }
            res += (num%x == 0)? 1: 0;
        }
        return res;
    }
}
```