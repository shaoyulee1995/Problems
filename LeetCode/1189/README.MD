# Maximum Number of Balloons

- Time Complexity: O(N)
- Space Complexity: O(1)

```java
class Solution {
    public int maxNumberOfBalloons(String text) {
        int b = 0, a = 0, l = 0, o = 0, n = 0;
        for(char c: text.toCharArray()){
            switch(c){
                case 'b':
                    b++;
                    break;
                case 'a':
                    a++;
                    break;
                case 'l':
                    l++;
                    break;
                case 'o':
                    o++;
                    break;
                case 'n':
                    n++;
                    break;
                default:
                    break;
            }
        }
        return Math.min(Math.min(o/2, l/2),
                       Math.min(b,Math.min(a, n)));
    }
}
```
