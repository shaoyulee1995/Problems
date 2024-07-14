# Three Consecutive Odds

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of arr

```java
class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        for(int i = 1; i + 1 < arr.length; i++){
            if(isOdd(arr[i-1], arr[i], arr[i+1])){
                return true;
            }
        }
        return false;
    }
    public boolean isOdd(int x, int y, int z){
        return x%2 != 0 && y%2 != 0 && z%2 != 0;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of arr

```java
class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        for(int i = 0, count = 0; i < arr.length; i++){
            if(arr[i]%2 == 0){
                count = 0;
            }else if(++count == 3){
                return true;
            }
        }
        return false;
    }
}
```
