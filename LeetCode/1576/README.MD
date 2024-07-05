# Replace All Questions to Avoid Consecutive Repeating Characters

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of s

```
class Solution {
    public String modifyString(String s) {
      char[] arr = s.toCharArray();
      for(int i = 0; i < arr.length; i++){
        if(arr[i] == '?'){
          arr[i] = pick(arr, i);
        }
      }
      return new String(arr);
    }

    public char pick(char[] arr, int i){
      char prev = i-1>=0? arr[i-1]: ' ',
           next = i+1<= arr.length-1? arr[i+1]: ' ',
           c = 'a';
      while(prev == c || next == c){
        c++;
      }
      return c;
    }
}
```
