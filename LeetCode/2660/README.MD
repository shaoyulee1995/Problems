# Determine the Winner of a Bowling Game

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of player1 or player2

```java
class Solution {
    public int isWinner(int[] player1, int[] player2) {
        int sum1 = player1[0],   
            sum2 = player2[0];
        for(int i = 1; i < player1.length; i++){
            int p1 = player1[i], 
                p2 = player2[i];
            if(isPlayerHit10(player1, i)){
                p1 *= 2;
            }
            if(isPlayerHit10(player2, i)){
                p2 *= 2;
            }
            sum1 += p1;
            sum2 += p2;
        }
        if(sum1 == sum2){
            return 0;
        }
        return (sum1 < sum2)? 2: 1;
    }

    private boolean isPlayerHit10(int[] player, int i){
        if(i == 1){
            return player[0] == 10;
        }
        return (player[i-1] == 10 || player[i-2] == 10);
    }
}
```
