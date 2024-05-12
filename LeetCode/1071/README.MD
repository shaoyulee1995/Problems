# Greatest Common Divisor of Strings
# String
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of str1 and str2
```
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)){
            return "";
        }
        int gcd = gcd(str1.length(), str2.length());
        return str2.substring(0, gcd);
    }
    public int gcd(int p, int q){
        return (q == 0)?p:gcd(q, p%q);
    }
}
```
# String
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of str1 and str2
```
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)){
            return "";
        }
        if(str1.equals(str2)){
            return str1;
        }
        if(str1.length() > str2.length()){
            return gcdOfStrings(str1.substring(str2.length()), str2);
        }
        return gcdOfStrings(str2.substring(str1.length()), str1);
    }
}
```