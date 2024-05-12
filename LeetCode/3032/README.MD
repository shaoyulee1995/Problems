# Count Numbers With Unique Digits II
# Math
* Time Complexity: O(ND)
* Space Complexity: O(D)
	* N as length between A and B
    * D as length of digits
```
class Solution {
    public int numberCount(int a, int b) {
        int res = 0;
        for(int i = a; i <= b; i++){
            res += (isUnique(i))? 1: 0;
        }
        return res;
    }

    public boolean isUnique(int num){
        HashSet<Integer> set = new HashSet();
        while(num != 0){
            if(!set.add(num%10)){
                return false;
            }
            num /= 10;
        }
        return true;
    }
}
```