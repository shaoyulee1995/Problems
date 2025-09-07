# Count Symmetric Integers

- Time Complexity: O(RN)
- Space Complexity: O(RN)
  - R as range between low and high
  - N as length of number

```java
class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int res = 0;
        for(int i = low; i <= high; i++){
            if(isSymmetric(i) && i > 10){
                res++;
            }
        }
        return res;
    }

    public boolean isSymmetric(int x){
        char[] val = String.valueOf(x).toCharArray();
        if(val.length%2 == 1){
            return false;
        }
        int i = 0,
            j = val.length-1,
            leftSum = 0,
            rightSum = 0;
        while(i < j){
            leftSum += val[i] - '0';
            rightSum += val[j] - '0';
            i++;
            j--;
        }
        return leftSum == rightSum;
    }
}
```

- Time Complexity: O(RN)
- Space Complexity: O(RN)
  - R as range between low and high
  - N as length of number

```java
class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int res = 0;
        for(int i = low; i <= high; i++){
            if(isSymmetric(i) && i > 10){
                res++;
            }
        }
        return res;
    }

    public boolean isSymmetric(int x){
        char[] val = String.valueOf(x).toCharArray();
        if(val.length%2 == 1){
            return false;
        }
        int leftSum = 0,
            rightSum = 0;
        for(int i = 0, j = val.length-1; i < j; i++, j--){
            leftSum += val[i] - '0';
            rightSum += val[j] - '0';
        }
        return leftSum == rightSum;
    }
}
```
