# Self Dividing Numbers

# PriorityQueue

- Time Complexity: O(Size(R-L))
- Space Complexity: O(Size(R-L))

```
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList();
        for(int i = left; i <= right; i++){
            if(valid(i)){
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean valid(int num){
        int temp = num;
        while(num != 0){
            int digit = num % 10;
            if(digit == 0){
                return false;
            }
            if(temp % digit != 0){
                return false;
            }
            num /= 10;
        }
        return true;
    }
}
```
