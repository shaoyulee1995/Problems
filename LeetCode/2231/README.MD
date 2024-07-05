# Largest Number After Digit Swaps by Parity

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(N)
  - N as length of num

```
class Solution {
    public int largestInteger(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        for(int i = 0; i+1 < chars.length; i++){
            for(int j = i+1; j < chars.length; j++){
                if(chars[j] > chars[i] && (chars[j] - chars[i])%2 == 0){
                    swap(chars, i, j);
                }
            }
        }
        return Integer.parseInt(new String(chars));
    }

    public void swap(char[] chars, int x, int y){
        char temp = chars[x];
        chars[x] = chars[y];
        chars[y] = temp;
    }
}
```
