# 2 Pointers
* Time Complexity: O((sqrt(N))
* Space Complexity: O(1)
```
class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num == 1 || num <= 0){
            return false;
        }
        int sum = 0;
        for(int i = 2; i * i < num; i++){
            if(num % i == 0){
                sum += i + num / i;
            }
        }
        return num == sum + 1;
    }
}
```