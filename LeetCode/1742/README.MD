# Maximum Number of Balls in a Box

- Time Complexity: O(N)
- Space Complexity: O(1)

```
class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int[] cnt = new int[46];
        for(int i = lowLimit; i <= highLimit; i++){
            cnt[sumDigits(i)]++;
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < cnt.length; i++){
            max = Math.max(max, cnt[i]);
        }
        return max;
    }
    public int sumDigits(int num){
        int sum = 0;
        while(num>0){
            int digit = num % 10;
            sum += digit;
            num = num / 10;
        }
        return sum;
    }
}
```
