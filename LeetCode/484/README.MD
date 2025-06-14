# Find Permutation

- Time Complexity: O(N)
- Space Complexity: O(N<sup>2</sup>)
  - N as length of s

```java
class Solution {
    public int[] findPermutation(String s) {
        Stack<Integer> stack = new Stack();
        int[] res = new int[s.length()+1];
        int j = 0;
        for(int i = 1; i <= s.length(); i++){
            stack.push(i);
            while(s.charAt(i-1) == 'I' && !stack.isEmpty()){
                res[j++] = stack.pop();
            }
        }
        stack.push(s.length()+1);
        while(!stack.isEmpty()){
            res[j++] = stack.pop();
        }
        return res;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N<sup>2</sup>)
  - N as length of s
  
```java
class Solution {
    public int[] findPermutation(String s) {
        int[] res = new int[s.length()+1];
        for(int i = 0; i <= s.length(); i++){
            res[i] = i+1;
        }
        for(int i = 0; i < s.length(); i++){
            int j = i;
            while(i < s.length() && s.charAt(i) == 'D'){
                i++;
            }
            reverse(res, j, i);
        }
        return res;
    }

    public void reverse(int[] res, int i, int j){
        while(i < j){
            int temp = res[i];
            res[i] = res[j];
            res[j] = temp;
            i++;
            j--;
        }
    }
}
```