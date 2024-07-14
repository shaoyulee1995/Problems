# Armstrong Number

- Time Complexity: O(D)
- Space Complexity: O(D)
  - N as length of digits

```java
class Solution {
    public boolean isArmstrong(int n) {
        int original = n;
        ArrayList<Integer> digits = new ArrayList();
        while(n > 0){
          digits.add(n%10);
          n /= 10;
        }
        int res = 0;
        for(int i = 0; i < digits.size(); i++){
          res += Math.pow(digits.get(i), digits.size());
        }
        return original == res;
    }
}
```
