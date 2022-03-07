# 2 Pointers
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of s
```
class Solution {
    public String reverseVowels(String s) {
        char[] c = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while(i < j){
            while(i < j && !isVowel(c[i])){
                i++;
            }
            while(i < j && !isVowel(c[j])){
                j--;
            }
            if(i >= j){
                break;
            }
            if(isVowel(c[i]) && isVowel(c[j])){
                swap(c, i, j);
                i++;j--;
            }
        }
        return new String(c);
    }
    private void swap(char[] c, int i, int j){
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
    private boolean isVowel(char c){
        return c =='a' || c =='e' || c =='i' || c =='o' || c =='u' || 
            c =='A' || c =='E' || c =='I' || c =='O' || c =='U';
    }
}
```