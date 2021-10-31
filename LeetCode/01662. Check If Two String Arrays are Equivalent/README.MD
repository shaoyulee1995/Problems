# String
* Time Complexity: O(Max(W1, W2))
* Space Complexity: O(M1+M2)
```
class Solution {
    public boolean arrayStringsAreEqual(String[] W1, String[] W2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for(String s: word1){
            sb1.append(s);
        }
        for(String s: word2){
            sb2.append(s);
        }
        return sb1.toString().equals(sb2.toString());
    }
}
```