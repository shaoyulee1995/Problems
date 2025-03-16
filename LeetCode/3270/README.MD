# Find the Key of the Numbers

- Time Complexity: O(1)
- Space Complexity: O(1)

```java
class Solution {
    public int generateKey(int num1, int num2, int num3) {
        int[] x = getNums(num1),
              y = getNums(num2),
              z = getNums(num3);
        return findMin(x, y, z);
    }

    public int[] getNums(int num){
        int[] res = new int[4];
        int i = res.length-1;
        while(num != 0){
            int digit = num%10;
            res[i--] = digit;
            num /= 10;
        }
        return res;
    }

    public int findMin(int[] x, int[] y, int[] z){
        int res = 0;
        for(int i = 0; i < x.length; i++){
            int min = Math.min(x[i], Math.min(y[i], z[i]));
            res = res*10 + min;
        }
        return res;
    }
}
```