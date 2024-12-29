# Minimum Factorization

- Time Complexity: O(logN)
- Space Complexity: O(1)

```java
class Solution {
    public int smallestFactorization(int num) {
        long base = 1,
             res = 0;
        if(num == 1){
            return 1;
        }
        for(int i = 9; i > 1; i--){
            while(num % i == 0){
                num /= i;
                res = base*i + res;
                base *= 10;
            }
            if(num == 1){
                break;
            }
        }
        return num == 1 && res <= Integer.MAX_VALUE? (int)res: 0;
    }
}
```