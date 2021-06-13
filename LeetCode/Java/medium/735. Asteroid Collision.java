class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int asteroid: asteroids){
            if(asteroid > 0){
                stack.push(asteroid);
            }else{
                while(!stack.isEmpty() && stack.peek() > 0 && Math.abs(asteroid) > stack.peek()){
                    stack.pop(); //10,2,-5
                }               
                //-2,-1,1,2
                if(stack.isEmpty() || stack.peek() < 0){
                    stack.push(asteroid);
                }else if(stack.peek() == Math.abs(asteroid)){//8,-8
                    stack.pop();
                }
            }
        }
        int[] output = new int[stack.size()];
        int i = 0;
        for(Integer num: stack){
            output[i++] = num;
        }
        return output;
        
    }
}