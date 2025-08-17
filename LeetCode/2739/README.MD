# Total Distance Traveled

- Time Complexity: O(log<sub>5</sub>M)
- Space Complexity: O(1)
  - M as mainTank

```java
class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int res = 0;
        while(mainTank >= 5 && additionalTank > 0){
            res += 50;
            mainTank = mainTank-5;
            additionalTank--;
            mainTank++;
        }
        res += mainTank*10;
        return res;
    }
}
```

- Time Complexity: O(1)
- Space Complexity: O(1)

```java
class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        return (mainTank + Math.min((mainTank-1)/4, additionalTank)) * 10;
    }
}
```