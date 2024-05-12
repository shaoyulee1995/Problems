# Evaluate Reverse Polish Notation
# BiFunction
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of token
```
class Solution {
    private static Map<String, BiFunction<Integer, Integer, Integer>> OPERATIONS = new HashMap();

    static{
        OPERATIONS.put("+", (a,b) -> a + b);
        OPERATIONS.put("-", (a,b) -> a - b);
        OPERATIONS.put("*", (a,b) -> a * b);
        OPERATIONS.put("/", (a,b) -> a / b);
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for(String token: tokens){
            if(!OPERATIONS.containsKey(token)){
                stack.push(Integer.valueOf(token));
                continue;
            }
            int num2 = stack.pop(),
                num1 = stack.pop();
            BiFunction<Integer, Integer, Integer> op = OPERATIONS.get(token);
            int res = op.apply(num1, num2);
            stack.push(res);
        }
        return stack.peek();
    }
}
```
# Stack
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of token
```
class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque();
        int a, b;
        for(String token: tokens){
            switch(token){
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a - b);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a / b);
                    break;
                default:
                    stack.push(Integer.valueOf(token));
                    break;
            }
        }
        return stack.pop();
    }
}
```
# Stack
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of token
```
class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> deque = new ArrayDeque();
        for(String token: tokens){
            if(token.equals("+") || 
               token.equals("-") || 
               token.equals("*") || 
               token.equals("/")){
                int second = deque.removeFirst(),
                    first = deque.removeFirst();
                if(token.equals("+")){
                    deque.addFirst(first + second);
                }else if(token.equals("-")){
                    deque.addFirst(first - second);
                }else if(token.equals("*")){
                    deque.addFirst(first * second);
                }else if(token.equals("/")){
                    deque.addFirst(first / second);
                }
            }else{
                deque.addFirst(Integer.valueOf(token));
            }    
        }
        return deque.peekFirst();
    }
}
```