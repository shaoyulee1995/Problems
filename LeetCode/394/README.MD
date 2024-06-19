# Decode String

# Stack

- Time Complexity: O(S)
- Space Complexity: O(S)
  - S as length of s

```
class Solution {
    public String decodeString(String s) {
        Stack<Integer> intStack = new Stack();
        Stack<StringBuilder> strStack = new Stack();
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for(char c: s.toCharArray()){
            if(Character.isDigit(c)){
                num = num*10 + c - '0';
            }else if(c == '['){
                intStack.push(num);
                strStack.push(sb);
                num = 0;
                sb = new StringBuilder();
            }else if(c == ']'){
                StringBuilder temp = sb;
                sb = strStack.pop();
                for(int i = intStack.pop(); i > 0; i--){
                    sb.append(temp);
                }
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
```

# Recursion

- Time Complexity: O(S)
- Space Complexity: O(S)
  - S as length of s

```
class Solution {
    public String decodeString(String s) {
        Deque<Character> deque = new ArrayDeque();
        for(char c: s.toCharArray()){
            deque.offer(c);
        }
        return decodeStringByRecursion(deque);
    }

    public String decodeStringByRecursion(Deque<Character> deque){
        StringBuilder sb = new StringBuilder();
        int k = 0;
        while(!deque.isEmpty()){
            char c = deque.poll();
            if(Character.isDigit(c)){
                k = k*10 + c - '0';
            }else if(c == '['){
                String sub = decodeStringByRecursion(deque);
                for(int i = 0; i < k; i++){
                    sb.append(sub);
                }
                k = 0;
            }else if(c == ']'){
                break;
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
```
