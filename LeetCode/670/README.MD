# Maximum Swap

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of chars

```java
class Solution {
    public int maximumSwap(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        int[] buckets = new int[10];
        for(int i = 0; i < chars.length; i++){
            buckets[chars[i]-'0'] = i;
        }

        for(int i = 0; i < chars.length; i++){
            for(int j = 9; j > chars[i]-'0'; j--){
                if(buckets[j] > i){
                    char temp = chars[i];
                    chars[i] = chars[buckets[j]];
                    chars[buckets[j]] = temp;
                    return Integer.valueOf(new String(chars));
                }
            }
        }
        return num;
    }
}
```
