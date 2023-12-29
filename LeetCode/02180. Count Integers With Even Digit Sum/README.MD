# Array
* Time Complexity: O(ND)
* Space Complexity: O(1)
    * N as num
    * D as digits of num
```
class Solution {
    public int countEven(int num) {
        int res = 0;
        while(num > 0){
            if(isEven(num)){
                res++;
            }
            num--;
        }
        return res;
    }
    public boolean isEven(int num){
        int res = 0;
        while(num > 0){
            res += num%10;
            num /= 10;
        }
        return res%2 == 0;
    }
}
```