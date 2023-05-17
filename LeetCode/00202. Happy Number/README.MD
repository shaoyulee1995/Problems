# HashSet
* Time Complexity: O(log(N))
* Space Complexity: O(1)
	* N as n
```
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet();
        while(n > 1){
            if(!set.add(n)){
                return false;
            }
            n = parse(n);
        }
        return n == 1;
    }

    public int parse(int n){
        int res = 0;
        while(n != 0){
            int num = n%10;
            res += Math.pow(num, 2);
            n /= 10;
        }
        return res;
    }
}
```