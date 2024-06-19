# Bulls and Cows

# Counting Array

- Time Complexity: O(S)
- Space Complexity: O(10)
  - S as length of secret

```
class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0,
            cows = 0;
        int[] numbers = new int[10];
        for(int i = 0; i < secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)){
                bulls++;
            }else{
                if(numbers[secret.charAt(i)-'0']++ < 0){
                    cows++;
                }
                if(numbers[guess.charAt(i)-'0']-- > 0){
                    cows++;
                }
            }
        }
        return bulls + "A" + cows + "B";
    }
}
```
