# Find the Sum of Encrypted Integers

- Time Complexity: O(ND)
- Space Complexity: O(1)
  - N as length of nums
  - D as max length of num in nums

```java
class Solution {
    public int sumOfEncryptedInt(int[] nums) {
        int res = 0;
        for(int num: nums){
            res += getEncrypted(num);
        }
        return res;
    }

    private int getEncrypted(int num){
        int res = 0,
            len = 0;
        while(num != 0){
            res = Math.max(res, num%10);
            num /= 10;
            len++;
        }
        return encrypt(res, len);
    }

    private int encrypt(int maxDigit, int len){
        StringBuilder sb = new StringBuilder();
        while(len != 0){
            sb.append(maxDigit);
            len--;
        }
        return Integer.valueOf(sb.toString());
    }
}
```