# Count of Matches in Tournament

- Time Complexity: O(logN)
- Space Complexity: O(1)

```java
class Solution {
    public int numberOfMatches(int n) {
        int cnt = 0;
        while(n>1){
            cnt += (n%2==1)? n/2 + 1: n/2;
            n/=2;
        }
        return cnt;
    }
}
```

- Time Complexity: O(1)
- Space Complexity: O(1)

```java
class Solution {
    public int numberOfMatches(int n) {
        return n - 1;
    }
}
```
