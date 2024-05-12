# Robot Bounded In Circle
# String
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of s
```
class Solution {
    public boolean isRobotBounded(String instructions) {
        int d = 0,
            x = 0,
            y = 0;
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        for(char c: instructions.toCharArray()){
            if(c == 'G'){
                x += dirs[d][0];
                y += dirs[d][1];
            }else if(c == 'L'){
                d = (d+3)%4;
            }else if(c == 'R'){
                d = (d+1)%4;
            }
        }
        return (x == 0 && y == 0) || d != 0;
    }
}
```