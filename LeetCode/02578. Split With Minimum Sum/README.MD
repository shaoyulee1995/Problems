# String
* Time Complexity: O(NlogN)
* Space Complexity: O(N)
	* N as length of num
```
class Solution {
    public int splitNum(int num) {
        char[] s = String.valueOf(num).toCharArray();
        Arrays.sort(s);
        int num1 = 0,
            num2 = 0;
        for(int i = 0; i < s.length; i+=2){
            num1 = num1*10 + s[i]-'0';
        }
        for(int j = 1; j < s.length; j+=2){
            num2 = num2*10 + s[j]-'0';
        }
        return num1 + num2;
    }
}
```