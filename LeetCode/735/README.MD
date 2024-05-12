# Asteroid Collision
# Stack
* Time Complexity: O(N)
* Space Complexity: O(N)
    * N as length of asteroids
```
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();
        for(int asteroid: asteroids){
            if(asteroid > 0){
                stack.push(asteroid);
            }else{
                while(!stack.isEmpty() && stack.peek() > 0 && Math.abs(asteroid) > stack.peek()){
                    stack.pop();
                }
                if(stack.isEmpty() || stack.peek() < 0){
                    stack.push(asteroid);
                }else if(stack.peek() == Math.abs(asteroid)){
                    stack.pop();
                }
            }
        }
        int[] res = new int[stack.size()];
        for(int i = res.length-1; !stack.isEmpty(); i--){
            res[i] = stack.pop();
        }
        return res;
    }
}
```