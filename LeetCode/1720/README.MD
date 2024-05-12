# Decode XORed Array
# Array
* Time Complexity: O(N)
* Space Complexity: O(N)
```
class Solution {
    public int[] decode(int[] encoded, int first) {
        int[] code = new int[encoded.length+1];
        code[0] = first;
        for(int i = 0; i < encoded.length; i++){
            code[i+1] = code[i] ^ encoded[i];
        }
        return code;
    }
}
```